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
@Table(name = "floracao", uniqueConstraints={@UniqueConstraint(columnNames ={"id", "estacao"})})
public class Floracao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoEstacoesAno estacao;

	// O Hibernate precisa do construtor padrão sem nada
	@Deprecated
	public Floracao() {
	}
	
	public Floracao(TipoEstacoesAno estacao) {
		this.estacao = estacao;
	}
	
	public Floracao(Long id, TipoEstacoesAno estacao) {
		this.id = id;
		this.estacao = estacao;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoEstacoesAno getEstacao() {
		return estacao;
	}

	public void setEstacao(TipoEstacoesAno floracao) {
		this.estacao = floracao;
	}

	@Override
	public String toString() {
		return "EstacoesAno [id=" + id + ", tipoEstacao=" + estacao + "]";
	}
	
}
