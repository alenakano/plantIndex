package com.project.nakano.plantindex.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.nakano.plantindex.jpa.model.Categoria;
import com.project.nakano.plantindex.jpa.model.PlantDetails;
import com.project.nakano.plantindex.jpa.model.SearchResult;

@RestController
public class SearchController {

  @Autowired
  private PlantRepository plantRepository;
  
  @Autowired
  private CategoriaRepository categoriaRepository;
  
  /** Resposta de busca pelo nome da planta e/ou categoria.
  *
  * @param name
  * @param cat
  *
  * @return String
  *
  */
  @GetMapping("/searchplants")
  public List<SearchResult> findPlants(
      @RequestParam(value = "name", defaultValue = "") String name, 
      @RequestParam(value = "category", defaultValue = "") String cat) {
    if (cat.isEmpty()) {
      return plantRepository.searchByNome(name);
    } 
    if (name.isEmpty()) {
      return plantRepository.searchByCategoria(cat);
    }
    return plantRepository.searchByNomeAndCategoria(name, cat);
  }

  /** Resposta de busca pelo nome da planta e/ou categoria.
  *
  * @param name
  * @param cat
  *
  * @return String
  *
  */
  @GetMapping("/categories")
  public List<Categoria> fetchCategories() {
    return (List<Categoria>) categoriaRepository.findAll();
  }
  
  @GetMapping("/plant/{id}")
  public Optional<PlantDetails> fetchPlant(@PathVariable Long id) {
    return plantRepository.findById(id);
  }
  
}
