package com.project.nakano.plantindex.jpa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.map.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.nakano.plantindex.jpa.model.Categoria;
import com.project.nakano.plantindex.jpa.model.Origem;
import com.project.nakano.plantindex.jpa.model.OutroNome;
import com.project.nakano.plantindex.jpa.model.PlantDetails;

@Service
public class SyncDatabaseService {

	@Autowired
	private PlantRepository plantRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private OutroNomeRepository outroNomeRepository;

	@Autowired
	private OrigemRepository origemRepository;
	
	public ResponseEntity<?> syncDatabase(String categoria) {

		List<String> plantsToSearch = new ArrayList<>();
		List<PlantDetails> plantDetailsList = new ArrayList<>();
		
		// Recuperar links href das plantas para pesquisa
		try {
			plantsToSearch = new PlantNamesFinder().searchPlantNames(categoria);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		// Busca detalhes da planta pelo link href recuperado.
		plantsToSearch.forEach(pl -> {
			try {
				
				MultiValueMap<String, String> collectedDetails = new PlantDetailsFinder().searchPlantDetails(pl);
				PlantDetails plantDetails = new PlantDetailsBuilder().setRecoveredPlantDetails(collectedDetails);
				
				this.insertIntoOutroNomeTable(plantDetails);
				this.insertIntoOrigemTable(plantDetails);
				this.insertIntoCategoriaTable(plantDetails);
				
				plantDetailsList.add(plantDetails);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		plantDetailsList.forEach(plant -> {
			PlantDetails p = plantRepository.findByNome(plant.getNome());
			// Se jÃ¡ existir, atualiza. Caso nÃ£o exista, salva
			if(Objects.isNull(p)) {
				plantRepository.save(plant);
			} else {
				plant.setId(p.getId());
				plantRepository.save(plant);
			}
		});
		
		return ResponseEntity.ok().body("Sucesso");
	}
	
	private void insertIntoCategoriaTable(PlantDetails plantDetails) {
		Categoria categoria = plantDetails.getCategoria();
		Categoria cat = categoriaRepository.findBynome(categoria.getNome());
		
		if(Objects.isNull(cat)) {
			categoriaRepository.save(categoria);
		} else {
			categoria.setId(cat.getId());
			categoriaRepository.save(categoria);
		}
	}
	
	private void insertIntoOrigemTable(PlantDetails plantDetails) {
		List<Origem> nomes = plantDetails.getOrigem();
		for (Origem origem : nomes) {
			Origem or = origemRepository.findByNome(origem.getNome());
				if(Objects.isNull(or)) {
					origemRepository.save(origem);
				} else {
					origem.setId(or.getId());
					origemRepository.save(origem);
				}
		}
	}
	
	private void insertIntoOutroNomeTable(PlantDetails plant) {
		List<OutroNome> nomes = plant.getOutrosNomes();
		for (OutroNome outroNome : nomes) {
			OutroNome nome = outroNomeRepository.findByNome(outroNome.getNome());
			if(Objects.isNull(nome)) { 
				outroNomeRepository.save(outroNome);
			} else {
				outroNome.setId(nome.getId());
				outroNomeRepository.save(outroNome);
			}
				
		}
	}
	
}
