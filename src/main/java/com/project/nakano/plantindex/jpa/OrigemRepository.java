package com.project.nakano.plantindex.jpa;

import org.springframework.data.repository.CrudRepository;

import com.project.nakano.plantindex.jpa.model.Origem;

public interface OrigemRepository extends CrudRepository<Origem, Long> {

	Origem findByNome(String nome);
	
}
