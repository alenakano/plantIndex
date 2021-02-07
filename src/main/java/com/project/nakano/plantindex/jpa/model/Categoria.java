package com.project.nakano.plantindex.jpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(unique=true)
	private TipoCategoria tipoCategoria;
	
	@OneToMany(mappedBy="categoria")
	List<PlantDetails> plantas;
	
	@Deprecated
	public Categoria() {
	}

	public Categoria(TipoCategoria tipoCategoria) {
		super();
		this.tipoCategoria = tipoCategoria;
	}
	
	public Categoria(Long id, TipoCategoria tipoCategoria) {
		super();
		this.id = id;
		this.tipoCategoria = tipoCategoria;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoCategoria getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(TipoCategoria tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", tipoCategoria=" + tipoCategoria + "]";
	}

	
}
