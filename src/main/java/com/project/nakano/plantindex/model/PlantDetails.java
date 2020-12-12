package com.project.nakano.plantindex.model;

import org.apache.commons.lang3.StringUtils;

public class PlantDetails {
	String nome;
	String outrosNomes;
	String ordem;
	String floração;
	String genero;
	String rega;
	String tamanho;
	Boolean perfumada;
	String tribo;
	String familia;
	String origem;
	String propagacao;
	String subfamília;
	CategoriaEnum categoria;
	String subtribo;
	String especie;
	String iluminacao;
	String plantio;
	String texto;
	String frutos;
	
	public PlantDetails() {
	}
	
	public PlantDetails(String nome, String outrosNomes, String ordem, String floração, String genero, String rega,
			String tamanho, String perfumada, String tribo, String familia, String origem, String propagacao,
			String subfamília, String categoria, String subtribo, String especie, String iluminacao, String plantio,
			String texto, String frutos) {
		this.nome = nome;
		this.outrosNomes = outrosNomes;
		this.ordem = ordem;
		this.floração = floração;
		this.genero = genero;
		this.rega = rega;
		this.tamanho = tamanho;
		this.setPerfumada(perfumada);
		this.tribo = tribo;
		this.familia = familia;
		this.origem = origem;
		this.propagacao = propagacao;
		this.subfamília = subfamília;
		this.setCategoria(categoria);
		this.subtribo = subtribo;
		this.especie = especie;
		this.iluminacao = iluminacao;
		this.plantio = plantio;
		this.texto = texto;
		this.frutos = frutos;
	}

	public PlantDetails(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getOutrosNomes() {
		return outrosNomes;
	}
	
	public void setOutrosNomes(String outrosNomes) {
		this.outrosNomes = outrosNomes;
	}
	
	public String getOrdem() {
		return ordem;
	}
	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}
	
	public String getFloração() {
		return floração;
	}
	
	public void setFloração(String floração) {
		this.floração = floração;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getRega() {
		return rega;
	}
	
	public void setRega(String rega) {
		this.rega = rega;
	}
	
	public String getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	public Boolean getPerfumada() {
		return perfumada;
	}
	
	public void setPerfumada(String perfumada) {
		if (perfumada.contains("sim")) {
			this.perfumada = true;
		} else { 
			this.perfumada = false;
		}
	}
	
	public String getTribo() {
		return tribo;
	}
	
	public void setTribo(String tribo) {
		this.tribo = tribo;
	}
	
	public String getFamilia() {
		return familia;
	}
	
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	public String getPropagacao() {
		return propagacao;
	}
	
	public void setPropagacao(String propagacao) {
		this.propagacao = propagacao;
	}
	
	public String getSubfamília() {
		return subfamília;
	}
	
	public void setSubfamília(String subfamília) {
		this.subfamília = subfamília;
	}
	
	public int getCategoria() {
		return categoria.getValue();
	}
	
	public void setCategoria(String categoria) {
		this.categoria = CategoriaEnum.valueOf(StringUtils.stripAccents(categoria).replace("[", "").replace("]", "").toUpperCase());
	}
	
	public String getSubtribo() {
		return subtribo;
	}
	
	public void setSubtribo(String subtribo) {
		this.subtribo = subtribo;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public String getIluminacao() {
		return iluminacao;
	}
	
	public void setIluminacao(String iluminacao) {
		this.iluminacao = iluminacao;
	}
	
	public String getPlantio() {
		return plantio;
	}
	
	public void setPlantio(String plantio) {
		this.plantio = plantio;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getFrutos() {
		return frutos;
	}
	
	public void setFrutos(String frutos) {
		this.frutos = frutos;
	}

	@Override
	public String toString() {
		return "PlantDetails [nome=" + nome + ", outrosNomes=" + outrosNomes + ", ordem=" + ordem + ", floração="
				+ floração + ", genero=" + genero + ", rega=" + rega + ", tamanho=" + tamanho + ", perfumada="
				+ perfumada + ", tribo=" + tribo + ", familia=" + familia + ", origem=" + origem + ", propagacao="
				+ propagacao + ", subfamília=" + subfamília + ", categoria=" + categoria + ", subtribo=" + subtribo
				+ ", especie=" + especie + ", iluminacao=" + iluminacao + ", plantio=" + plantio + ", texto=" + texto
				+ ", frutos=" + frutos + "]";
	}
	
}
