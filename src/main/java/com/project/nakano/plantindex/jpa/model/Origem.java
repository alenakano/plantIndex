package com.project.nakano.plantindex.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Origem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	@Deprecated
	public Origem() {
	}
	
	public Origem(String origem) {
		this.nome = origem;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigem() {
		return nome;
	}

	public void setOrigem(String origem) {
		this.nome = origem;
	}

	@Override
	public String toString() {
		return "Origem [id=" + id + ", nome=" + nome + "]";
	}

	
}
