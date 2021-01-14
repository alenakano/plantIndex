package com.project.nakano.plantindex.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OutroNome {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	public OutroNome(String outroNome) {
		this.nome = outroNome;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOutroNome() {
		return nome;
	}

	public void setOutroNome(String outroNome) {
		this.nome = outroNome;
	}

}
