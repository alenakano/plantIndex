package com.project.nakano.plantindex.jpa;

import com.project.nakano.plantindex.jpa.model.PlantDetails;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<PlantDetails, Long>, FindByNome<PlantDetails> {

  PlantDetails findByNome(String nome);

}