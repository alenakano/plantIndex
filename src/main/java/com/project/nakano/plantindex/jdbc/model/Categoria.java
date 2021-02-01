package com.project.nakano.plantindex.jdbc.model;

public class Categoria {
	
	private int id;
	private String nome;
	
	public Categoria() {}
	
	public Categoria(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categorias [id=" + id + ", nome=" + nome + "]";
	}
	
	

}