package com.project.nakano.plantindex.jpa.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name = "propagacao", uniqueConstraints={@UniqueConstraint(columnNames ={"id", "tipoPropagacao"})})
public class Propagacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoPropagacao tipoPropagacao;

	// O Hibernate precisa do construtor padrão sem nada
	@Deprecated
	public Propagacao() {
	}
	
	public Propagacao(TipoPropagacao prop) {
		this.tipoPropagacao = prop;
	}
	
	public Propagacao(Long id, TipoPropagacao tipoPropagacao) {
		super();
		this.id = id;
		this.tipoPropagacao = tipoPropagacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPropagacao getTipoPropagacao() {
		return tipoPropagacao;
	}

	public void setTipoPropagacao(TipoPropagacao tipoPropagacao) {
		this.tipoPropagacao = tipoPropagacao;
	}

	@Override
	public String toString() {
		return "Propagacao [id=" + id + ", tipoPropagacao=" + tipoPropagacao + "]";
	}

}
