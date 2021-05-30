package com.project.nakano.plantindex.jpa;

import com.project.nakano.plantindex.jpa.model.PlantDetails;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantByNameController {

  @Autowired
  private PlantRepository plantRepository;
  
  /** Resposta de busca pelo nome da planta.
  *
  * @param name
  *
  * @return String
  *
  */
  @GetMapping("/searchPlantByName")
  public String fetchPlantByName(@RequestParam(value = "name", defaultValue = "") String name) {
    PlantDetails resp = plantRepository.findByNome(name);
    if (Objects.isNull(resp)) {
      return new String("Sem resultados");
    } else {
      return resp.toStringHTML();
    }
  }
}
