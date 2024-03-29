package com.project.nakano.plantindex.jpa;

import org.springframework.data.repository.CrudRepository;

import com.project.nakano.plantindex.jpa.model.OutroNome;

public interface OutroNomeRepository extends CrudRepository<OutroNome, Long>, FindByNome<OutroNome> {
	OutroNome findByNome(String nome);
}
