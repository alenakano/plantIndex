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
@Table(name = "estacoes_ano", uniqueConstraints={@UniqueConstraint(columnNames ={"id", "tipoEstacao"})})
public class EstacoesAno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoEstacoesAno tipoEstacao;

	// O Hibernate precisa do construtor padrão sem nada
	@Deprecated
	public EstacoesAno() {
	}
	
	public EstacoesAno(TipoEstacoesAno tipo) {
		this.tipoEstacao = tipo;
	}
	
	public EstacoesAno(Long id, TipoEstacoesAno tipo) {
		this.id = id;
		this.tipoEstacao = tipo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoEstacoesAno getEstacao() {
		return tipoEstacao;
	}

	public void setEstacao(TipoEstacoesAno estacao) {
		this.tipoEstacao = estacao;
	}

	@Override
	public String toString() {
		return "EstacoesAno [id=" + id + ", tipoEstacao=" + tipoEstacao + "]";
	}
	
}
