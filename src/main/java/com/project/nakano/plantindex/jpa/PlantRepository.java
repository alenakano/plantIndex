package com.project.nakano.plantindex.jpa;

import org.springframework.data.repository.CrudRepository;
import com.project.nakano.plantindex.jpa.model.PlantDetails;

public interface PlantRepository extends CrudRepository<PlantDetails, Integer> {

}