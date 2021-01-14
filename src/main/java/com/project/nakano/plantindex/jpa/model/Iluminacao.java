package com.project.nakano.plantindex.jpa.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "iluminacao", uniqueConstraints={@UniqueConstraint(columnNames ={"id", "tipoIluminacao"})})
public class Iluminacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoIluminacao tipoIluminacao;

	// O Hibernate precisa do construtor padrão sem nada
	@Deprecated
	public Iluminacao() {
	}
	
	public Iluminacao(TipoIluminacao ilu) {
		this.tipoIluminacao = ilu;
	}

	public Iluminacao(Long value, TipoIluminacao ilu) {
		this.id = value;
		this.tipoIluminacao = ilu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoIluminacao getTipoIluminacao() {
		return tipoIluminacao;
	}

	public void setTipoIluminacao(TipoIluminacao tipoIluminacao) {
		this.tipoIluminacao = tipoIluminacao;
	}
	
}
