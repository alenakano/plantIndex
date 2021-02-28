package com.project.nakano.plantindex.jpa.model;

import javax.persistence.Entity;

@Entity
public class OutroNome extends NamedId {
	
	@Deprecated
	public OutroNome(){}
	
	public OutroNome(String nome) {
		super(nome);
	}
	
}
