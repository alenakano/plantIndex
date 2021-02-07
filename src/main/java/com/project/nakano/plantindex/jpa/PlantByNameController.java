package com.project.nakano.plantindex.jpa;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.nakano.plantindex.jpa.model.PlantDetails;

@RestController
public class PlantByNameController {

	@Autowired
	private PlantRepository plantRepository;
	
	
	@GetMapping("/searchPlantByName")
	public String fetchPlantByName(@RequestParam(value = "name", defaultValue = "") String name) {
		
		System.out.println("I'm alive. PlantName: " + name);
		PlantDetails resp = plantRepository.findByNome(name);
		if(Objects.isNull(resp)) {
			return new String("Sem resultados");
		} else {
			return resp.toStringHTML();
		}
		

	}
}
