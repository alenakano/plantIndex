package com.project.nakano.plantindex.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.nakano.plantindex.jpa.model.PlantDetails;
import com.project.nakano.plantindex.jpa.model.SearchResult;

public interface PlantRepository extends 
  CrudRepository<PlantDetails, Long>, 
  FindByNome<PlantDetails> {

  PlantDetails findByNome(String nome);
  
  @Query("SELECT new com.project.nakano.plantindex.jpa.model.SearchResult(p.id, p.nome, SUBSTRING(p.texto, 1, 180)) FROM PlantDetails p WHERE p.nome LIKE ?1%")
  List<SearchResult> searchByNome(String nome);
  
  @Query("SELECT new com.project.nakano.plantindex.jpa.model.SearchResult(p.id, p.nome, SUBSTRING(p.texto, 1, 180)) FROM PlantDetails p WHERE p.nome = ?1 AND p.categoria.nome = ?2")
  List<SearchResult> searchByNomeAndCategoria(String nome, String categoria);
  
  @Query("SELECT new com.project.nakano.plantindex.jpa.model.SearchResult(p.id, p.nome, SUBSTRING(p.texto, 1, 180)) FROM PlantDetails p WHERE p.categoria.nome = ?1")
  List<SearchResult> searchByCategoria(String categoria);
}