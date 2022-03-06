package com.project.nakano.plantindex.jpa;

import com.project.nakano.plantindex.jpa.model.NamedId;
import com.project.nakano.plantindex.jpa.model.PlantDetails;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

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

  @Autowired
  private PlantNamesFinder plantNamesFinder;
  
  @Autowired
  private PlantDetailsFinder plantDetailsFinder;
  
  @Autowired
  PlantDetailsBuilder plantDetailsBuilder;
  
  /** Sincroniza database com informações do site MinhasPlantas.
   *
   * @param categoria
   *
   * @return ResponseEntity
   *
   */
  public ResponseEntity<?> syncDatabase(String categoria) {
  
    List<String> plantsToSearch = new ArrayList<>();
    List<PlantDetails> plantDetailsList = new ArrayList<>();
    
    // Recuperar links href das plantas para pesquisa
    try {
      plantsToSearch = plantNamesFinder.searchPlantNames(categoria);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    // Busca detalhes da planta pelo link href recuperado.
    plantsToSearch.forEach(pl -> {
      try {
        
        MultiValueMap<String, String> collectedDetails = plantDetailsFinder.searchPlantDetails(pl);
        PlantDetails plantDetails = plantDetailsBuilder.setRecoveredPlantDetails(collectedDetails);
        plantDetails
          .getOrigem()
            .forEach(or -> this.insertIntoTable(origemRepository, or));
        plantDetails
          .getOutrosNomes()
            .forEach(nome -> this.insertIntoTable(outroNomeRepository, nome));
        this.insertIntoTable(categoriaRepository, plantDetails.getCategoria());
        
        plantDetailsList.add(plantDetails);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    
    plantDetailsList
      .forEach(plant -> this.insertIntoTable(plantRepository, plant));
    
    return ResponseEntity.ok().body("Sucesso");
  }
  
  private <T extends CrudRepository<E, Long> & FindByNome<E>, E extends NamedId> 
      void insertIntoTable(T repository, E newData) { 
    E recoveredData = repository.findByNome(newData.getNome());
    if (Objects.isNull(recoveredData)) {
      repository.save(newData);
    } else {
      newData.setId(recoveredData.getId());
      repository.save(newData);
    }     
  }
}
