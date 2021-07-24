package com.project.nakano.plantindex.jpa.model;

import javax.persistence.Entity;

@Entity
public class Origem extends NamedId {
	
	@Deprecated
	public Origem() {
		super();
	}
	
	public Origem(String nome) {
		super(nome);
	}
	
}
