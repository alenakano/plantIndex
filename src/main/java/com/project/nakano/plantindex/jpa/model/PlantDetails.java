package com.project.nakano.plantindex.jpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "plant_details", uniqueConstraints={@UniqueConstraint(columnNames ={"id", "nome"})})
public class PlantDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

//	@Column(unique=true)
	String nome;

	@ManyToMany
	@JoinTable(
	  joinColumns = @JoinColumn(name = "plant_details_id"), 
	  inverseJoinColumns = @JoinColumn(name = "outro_nome_id")
	  )
	List<OutroNome> outrosNomes;
	
	String ordem;

	@ManyToMany
	@JoinTable(
	  joinColumns = @JoinColumn(name = "plant_details_id"), 
	  inverseJoinColumns = @JoinColumn(name = "estacoes_ano_id")
	  )
	List<EstacoesAno> floracao;
	
	String genero;
	
	@Enumerated(EnumType.STRING)
	TipoRega rega;
	
	String tamanho;
	
	Boolean perfumada;
	
	String tribo;
	
	String familia;
	
	@ManyToMany
	@JoinTable(
			  joinColumns = @JoinColumn(name = "plant_details_id"), 
			  inverseJoinColumns = @JoinColumn(name = "origem_id")
			  )
	List<Origem> origem;

	@ManyToMany
	@JoinTable(
			  joinColumns = @JoinColumn(name = "plant_details_id"), 
			  inverseJoinColumns = @JoinColumn(name = "propagacao_id")
			  )
	List<Propagacao> propagacao;
	
	String subFamilia;

	@ManyToOne
	@JoinColumn(name = "categoria")
	Categoria categoria;
	
	String subtribo;
	
	String especie;
	
	@ManyToMany
	@JoinTable(
			  joinColumns = @JoinColumn(name = "plant_details_id"), 
			  inverseJoinColumns = @JoinColumn(name = "iluminacao_id")
			  )
	List<Iluminacao> iluminacao;

	@ManyToMany
	@JoinTable(
			  joinColumns = @JoinColumn(name = "plant_details_id"), 
			  inverseJoinColumns = @JoinColumn(name = "estacoes_ano_id")
			  )
	List<EstacoesAno> plantio;
	
	@Column(name="texto",columnDefinition="LONGTEXT")
	String texto;
	
	Boolean frutoComestivel;

	public PlantDetails() {
	}

	public PlantDetails(
				String nome, 
				List<OutroNome> outrosNomes, 
				String ordem, 
				List<EstacoesAno> floracao,
				String genero, 
				TipoRega rega, 
				String tamanho, 
				Boolean perfumada, 
				String tribo, 
				String familia,
				List<Origem> origem, 
				List<Propagacao> propagacao, 
				String subFamilia, 
				Categoria categoria,
				String subTribo, 
				String especie, 
				List<Iluminacao> iluminacao, 
				List<EstacoesAno> plantio, 
				String infos,
				Boolean frutoComestivel
			) {
		this.nome = nome;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public List<EstacoesAno> getFloracao() {
		return floracao;
	}

	public void setFloracao(List<EstacoesAno> floracao) {
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

	public List<Propagacao> getPropagacao() {
		return propagacao;
	}

	public void setPropagacao(List<Propagacao> propagacao) {
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

	public List<Iluminacao> getIluminacao() {
		return iluminacao;
	}

	public void setIluminacao(List<Iluminacao> iluminacao) {
		this.iluminacao = iluminacao;
	}

	public List<EstacoesAno> getPlantio() {
		return plantio;
	}

	public void setPlantio(List<EstacoesAno> plantio) {
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

	@Override
	public String toString() {
		return "PlantDetails [nome=" + nome + ", outrosNomes=" + outrosNomes + ", ordem=" + ordem + ", floracao="
				+ floracao + ", genero=" + genero + ", rega=" + rega + ", tamanho=" + tamanho + ", perfumada="
				+ perfumada + ", tribo=" + tribo + ", familia=" + familia + ", origem=" + origem + ", propagacao="
				+ propagacao + ", subfamília=" + subFamilia + ", categoria=" + categoria + ", subtribo=" + subtribo
				+ ", especie=" + especie + ", iluminacao=" + iluminacao + ", plantio=" + plantio + ", texto=" + texto
				+ ", frutos=" + frutoComestivel + "]";
	}

}