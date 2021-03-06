package com.project.nakano.plantindex.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.nakano.plantindex.jpa.model.Categoria;

@Component
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

	public Categoria findByNome(String nome);
	
}