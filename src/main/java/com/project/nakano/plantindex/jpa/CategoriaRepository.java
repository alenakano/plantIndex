package com.project.nakano.plantindex.jpa;

import com.project.nakano.plantindex.jpa.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

  public Categoria findByNome(String nome);

}