package com.project.nakano.plantindex.jpa;

import org.springframework.data.repository.CrudRepository;

import com.project.nakano.plantindex.jpa.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}