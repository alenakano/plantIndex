package com.project.nakano.plantindex.jpa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.nakano.plantindex.jpa.model.PlantDetails;

@RestController
public class UpdateDatabaseJPAController extends PlantDetailsBuilder {

	@Autowired
	private PlantRepository plantRepository;

	@GetMapping("/updatedatabasejpa")
	public String updateDatase(@RequestParam(value = "categoria", defaultValue = "") String categoria)
			throws IOException {

		String status = "Sucesso";
		List<String> plantsToSearch = new ArrayList<String>();
		List<PlantDetails> plantDetailsList = new ArrayList<>();

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
				plantDetailsList.add(setRecoveredPlantDetails(PlantDetailsFinder.searchPlantDetails(pl)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		plantDetailsList.forEach(plant -> plantRepository.save(plant));

		return status;
	}
}
