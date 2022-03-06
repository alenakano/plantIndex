package com.project.nakano.plantindex.jpa;

import com.project.nakano.plantindex.jpa.model.Origem;
import org.springframework.data.repository.CrudRepository;

public interface OrigemRepository extends CrudRepository<Origem, Long>, FindByNome<Origem> {

  Origem findByNome(String nome);

}
