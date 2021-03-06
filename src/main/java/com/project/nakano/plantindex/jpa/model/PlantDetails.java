package com.project.nakano.plantindex.jpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "plant_details", uniqueConstraints={@UniqueConstraint(columnNames ={"id", "nome"})})
public class PlantDetails extends NamedId {

	@ManyToMany
	@JoinTable(
	  joinColumns = @JoinColumn(name = "plant_details_id"), 
	  inverseJoinColumns = @JoinColumn(name = "outro_nome_id")
	  )
	private List<OutroNome> outrosNomes;
	
	private String ordem;

	@ElementCollection
	private List<TipoEstacoesAno> floracao;
	
	private String genero;
	
	@Enumerated(EnumType.STRING)
	private TipoRega rega;
	
	private String tamanho;
	
	private Boolean perfumada;
	
	private String tribo;
	
	private String familia;
	
	@ManyToMany
	@JoinTable(
			  joinColumns = @JoinColumn(name = "plant_details_id"), 
			  inverseJoinColumns = @JoinColumn(name = "origem_id")
			  )
	private List<Origem> origem;

	@ElementCollection
	private List<TipoPropagacao> propagacao;
	
	private String subFamilia;

	@ManyToOne
	@JoinColumn(name = "categoria")
	private Categoria categoria;
	
	private String subtribo;
	
	private String especie;
	
	@ElementCollection
	private List<TipoIluminacao> iluminacao;

	@ElementCollection
	private List<TipoEstacoesAno> plantio;
	
	@Column(name="texto",columnDefinition="LONGTEXT")
	private String texto;
	
	private Boolean frutoComestivel;

	public PlantDetails() {
	}
	
	public PlantDetails(PlantDetails plant) {
		super.setNome(plant.getNome());
		this.outrosNomes = plant.outrosNomes;
		this.ordem = plant.ordem;
		this.floracao = plant.floracao;
		this.genero = plant.genero;
		this.rega = plant.rega;
		this.tamanho = plant.tamanho;
		this.perfumada = plant.perfumada;
		this.tribo = plant.tribo;
		this.familia = plant.familia;
		this.origem = plant.origem;
		this.propagacao = plant.propagacao;
		this.subFamilia = plant.subFamilia;
		this.categoria = plant.categoria;
		this.subtribo = plant.subtribo;
		this.especie = plant.especie;
		this.iluminacao = plant.iluminacao;
		this.plantio = plant.plantio;
		this.texto = plant.texto;
		this.frutoComestivel = plant.frutoComestivel;
	}

	public PlantDetails(
				String nome, 
				List<OutroNome> outrosNomes, 
				String ordem, 
				List<TipoEstacoesAno> floracao,
				String genero, 
				TipoRega rega, 
				String tamanho, 
				Boolean perfumada, 
				String tribo, 
				String familia,
				List<Origem> origem, 
				List<TipoPropagacao> propagacao, 
				String subFamilia, 
				Categoria categoria,
				String subTribo, 
				String especie, 
				List<TipoIluminacao> iluminacao, 
				List<TipoEstacoesAno> plantio, 
				String infos,
				Boolean frutoComestivel
			) {
		super.setNome(nome);
		this.outrosNomes = outrosNomes;
		this.ordem = ordem;
		this.floracao = floracao;
		this.genero = genero;
		this.rega = rega;
		this.tamanho = tamanho;
		this.perfumada = perfumada;
		this.tribo = tribo;
		this.familia = familia;
		this.origem = origem;
		this.propagacao = propagacao;
		this.subFamilia = subFamilia;
		this.categoria = categoria;
		this.subtribo = subTribo;
		this.especie = especie;
		this.iluminacao = iluminacao;
		this.plantio = plantio;
		this.texto = infos;
		this.frutoComestivel = frutoComestivel;
	}
	public List<OutroNome> getOutrosNomes() {
		return outrosNomes;
	}

	public void setOutrosNomes(List<OutroNome> outrosNomes) {
		this.outrosNomes = outrosNomes;
	}

	public String getOrdem() {
		return ordem;
	}

	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}

	public List<TipoEstacoesAno> getFloracao() {
		return floracao;
	}

	public void setFloracao(List<TipoEstacoesAno> floracao) {
		this.floracao = floracao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public TipoRega getRega() {
		return rega;
	}

	public void setRega(TipoRega rega) {
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

	public void setPerfumada(Boolean perfumada) {
		this.perfumada = perfumada;
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

	public List<Origem> getOrigem() {
		return origem;
	}

	public void setOrigem(List<Origem> origem) {
		this.origem = origem;
	}

	public List<TipoPropagacao> getPropagacao() {
		return propagacao;
	}

	public void setPropagacao(List<TipoPropagacao> propagacao) {
		this.propagacao = propagacao;
	}

	public String getSubfamilia() {
		return subFamilia;
	}

	public void setSubfamilia(String subFamilia) {
		this.subFamilia = subFamilia;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public List<TipoIluminacao> getTipoIluminacao() {
		return iluminacao;
	}

	public void setTipoIluminacao(List<TipoIluminacao> iluminacao) {
		this.iluminacao = iluminacao;
	}

	public List<TipoEstacoesAno> getPlantio() {
		return plantio;
	}

	public void setPlantio(List<TipoEstacoesAno> plantio) {
		this.plantio = plantio;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Boolean getFrutos() {
		return frutoComestivel;
	}

	public void setFrutos(Boolean frutos) {
		this.frutoComestivel = frutos;
	}
	
	public String toStringHTML() {
		return "<h1>" + super.getNome().toUpperCase() + "</h1><h3>nome</h3>" + super.getNome() + "<br/><h3>outrosNomes</h3>" + outrosNomes + "<br/><h3>ordem</h3>" + ordem + "<br/><h3>floracao</h3>"
				+ floracao + "<br/><h3>genero</h3>" + genero + "<br/><h3>rega</h3>" + rega + "<br/><h3>tamanho</h3>" + tamanho + "<br/><h3>perfumada</h3>"
				+ perfumada + "<br/><h3>tribo</h3>" + tribo + "<br/><h3>familia</h3>" + familia + "<br/><h3>origem</h3>" + origem + "<br/><h3>propagacao</h3>"
				+ propagacao + "<br/><h3>subfamília</h3>" + subFamilia + "<br/><h3>categoria</h3>" + categoria.getNome() + "<br/><h3>subtribo</h3>" + subtribo
				+ "<br/><h3>especie</h3>" + especie + "<br/><h3>iluminacao</h3>" + iluminacao + "<br/><h3>plantio</h3>" + plantio 
				+ "<br/><h3>frutos</h3>" + frutoComestivel + "<br/><br/><h1>TEXTO</h1>" + texto;
	}

}
