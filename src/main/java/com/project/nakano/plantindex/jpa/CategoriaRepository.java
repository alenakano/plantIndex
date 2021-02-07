package com.project.nakano.plantindex.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.nakano.plantindex.jpa.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Categoria findByTipoCategoria(String tipoCategoria);
	
}