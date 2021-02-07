package com.project.nakano.plantindex.jpa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.map.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.nakano.plantindex.jpa.model.Categoria;
import com.project.nakano.plantindex.jpa.model.Floracao;
import com.project.nakano.plantindex.jpa.model.Iluminacao;
import com.project.nakano.plantindex.jpa.model.Origem;
import com.project.nakano.plantindex.jpa.model.OutroNome;
import com.project.nakano.plantindex.jpa.model.PlantDetails;
import com.project.nakano.plantindex.jpa.model.Plantio;
import com.project.nakano.plantindex.jpa.model.Propagacao;
import com.project.nakano.plantindex.jpa.model.TipoEstacoesAno;
import com.project.nakano.plantindex.jpa.model.TipoIluminacao;
import com.project.nakano.plantindex.jpa.model.TipoPropagacao;

@RestController
public class UpdateDatabaseJPAController extends PlantDetailsBuilder {

	@Autowired
	private PlantRepository plantRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private OutroNomeRepository outroNomeRepository;
	
	@Autowired
	private FloracaoRepository floracaoRepository;

	@Autowired
	private PlantioRepository plantioRepository;
	
	@Autowired
	private PropagacaoRepository propagacaoRepository;
	
	@Autowired
	private IluminacaoRepository iluminacaoRepository;
	
	@Autowired
	private OrigemRepository origemRepository;

	@GetMapping("/updatedatabasejpa")
	public String updateDatase(@RequestParam(value = "categoria", defaultValue = "") String categoria)
			throws IOException {

		String status = "Sucesso";
		List<String> plantsToSearch = new ArrayList<String>();
		List<PlantDetails> plantDetailsList = new ArrayList<>();

		this.insertIntoFloracaoTable();
		this.insertIntoPlantioTable();
		this.insertIntoIluminacaoTable();
		this.insertIntoPropagacaoTable();
		
		// Recuperar links href das plantas para pesquisa
		try {
			plantsToSearch = PlantNamesFinder.searchPlantNames(categoria);
		} catch (Exception e) {
			e.printStackTrace();
			status = "Falha";
		}

		// Busca detalhes da planta pelo link href recuperado.
		plantsToSearch.forEach(pl -> {
			try {
				
				MultiValueMap<String, String> collectedDetails = PlantDetailsFinder.searchPlantDetails(pl);
				PlantDetails plantDetails = setRecoveredPlantDetails(collectedDetails);
				
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
			// Se já existir, atualiza. Caso não exista, salva
			if(Objects.isNull(p)) {
				plantRepository.save(plant);
			} else {
				plant.setId(p.getId());
				plantRepository.save(plant);
			}
		});

		return status;
	}
	
	/*
	 * INSERT ENUMS 
	 */
	public void insertIntoFloracaoTable() {
		floracaoRepository.save(new Floracao(TipoEstacoesAno.PRIMAVERA.getValue(), TipoEstacoesAno.PRIMAVERA));
		floracaoRepository.save(new Floracao(TipoEstacoesAno.VERAO.getValue(), TipoEstacoesAno.VERAO));
		floracaoRepository.save(new Floracao(TipoEstacoesAno.OUTONO.getValue(), TipoEstacoesAno.OUTONO));
		floracaoRepository.save(new Floracao(TipoEstacoesAno.INVERNO.getValue(), TipoEstacoesAno.INVERNO));
		floracaoRepository.save(new Floracao(TipoEstacoesAno.ANOTODO.getValue(), TipoEstacoesAno.ANOTODO));
		floracaoRepository.save(new Floracao(TipoEstacoesAno.SEM.getValue(), TipoEstacoesAno.SEM));
	}

	public void insertIntoIluminacaoTable() {
		iluminacaoRepository.save(new Iluminacao(TipoIluminacao.SOMBRA.getValue(), TipoIluminacao.SOMBRA));
		iluminacaoRepository.save(new Iluminacao(TipoIluminacao.MEIASOMBRA.getValue(), TipoIluminacao.MEIASOMBRA));
		iluminacaoRepository.save(new Iluminacao(TipoIluminacao.SOLPLENO.getValue(), TipoIluminacao.SOLPLENO));
	}
	
	public void insertIntoPlantioTable() {
		plantioRepository.save(new Plantio(TipoEstacoesAno.PRIMAVERA.getValue(), TipoEstacoesAno.PRIMAVERA));
		plantioRepository.save(new Plantio(TipoEstacoesAno.VERAO.getValue(), TipoEstacoesAno.VERAO));
		plantioRepository.save(new Plantio(TipoEstacoesAno.OUTONO.getValue(), TipoEstacoesAno.OUTONO));
		plantioRepository.save(new Plantio(TipoEstacoesAno.INVERNO.getValue(), TipoEstacoesAno.INVERNO));
		plantioRepository.save(new Plantio(TipoEstacoesAno.ANOTODO.getValue(), TipoEstacoesAno.ANOTODO));
		plantioRepository.save(new Plantio(TipoEstacoesAno.SEM.getValue(), TipoEstacoesAno.SEM));
	}
	
	public void insertIntoPropagacaoTable() {
		propagacaoRepository.save(new Propagacao(TipoPropagacao.ESTACA.getValue(), TipoPropagacao.ESTACA));
		propagacaoRepository.save(new Propagacao(TipoPropagacao.TOUCEIRA.getValue(), TipoPropagacao.TOUCEIRA));
		propagacaoRepository.save(new Propagacao(TipoPropagacao.MUDA.getValue(), TipoPropagacao.MUDA));
		propagacaoRepository.save(new Propagacao(TipoPropagacao.SEMENTE.getValue(), TipoPropagacao.SEMENTE));
		propagacaoRepository.save(new Propagacao(TipoPropagacao.BULBO.getValue(), TipoPropagacao.BULBO));
	}
	
	
	/*
	 * CHECK BEFORE INSERTION
	 */
	public void insertIntoCategoriaTable(PlantDetails plantDetails) {
		Categoria categoria = plantDetails.getCategoria();
		Categoria cat = categoriaRepository.findByTipoCategoria(categoria.getTipoCategoria());
		
		if(Objects.isNull(cat)) {
			categoriaRepository.save(categoria);
		} else {
			categoria.setId(cat.getId());
			categoriaRepository.save(categoria);
		}
	}
	
	public void insertIntoOrigemTable(PlantDetails plantDetails) {
		List<Origem> nomes = plantDetails.getOrigem();
		for (Origem origem : nomes) {
			Origem or = origemRepository.findByNome(origem.getOrigem());
				if(Objects.isNull(or)) {
					origemRepository.save(origem);
				} else {
					origem.setId(or.getId());
					origemRepository.save(origem);
				}
		}
	}
	
	public void insertIntoOutroNomeTable(PlantDetails plant) {
		List<OutroNome> nomes = plant.getOutrosNomes();
		for (OutroNome outroNome : nomes) {
			OutroNome nome = outroNomeRepository.findByNome(outroNome.getOutroNome());
			if(Objects.isNull(nome)) { 
				outroNomeRepository.save(outroNome);
			} else {
				outroNome.setId(nome.getId());
				outroNomeRepository.save(outroNome);
			}
				
		}
	}
	
}
