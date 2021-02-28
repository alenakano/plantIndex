package com.project.nakano.plantindex.jpa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Categoria extends NamedId {
	
	@OneToMany(mappedBy="categoria")
	List<PlantDetails> plantas;
	
	@Deprecated
	public Categoria() {
	}

	public Categoria(String nome) {
		super(nome);
	}
	
}
