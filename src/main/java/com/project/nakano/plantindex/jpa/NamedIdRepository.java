package com.project.nakano.plantindex.jpa;

import java.util.Objects;

import org.springframework.data.repository.CrudRepository;

import com.project.nakano.plantindex.jpa.model.NamedId;

public interface NamedIdRepository<T extends NamedId> extends CrudRepository<T, Long> {
	
	T findBynome(String nome);
	
}
