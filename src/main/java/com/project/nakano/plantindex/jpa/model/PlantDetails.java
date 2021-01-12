package com.project.nakano.plantindex.jpa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "table_name", uniqueConstraints={@UniqueConstraint(columnNames ={"id", "nome"})})
public class PlantDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@OneToOne
	String nome;

	@ManyToMany
	List<String> outrosNomes;
	
	@ManyToOne
	String ordem;
	
	@Enumerated(EnumType.STRING)
	@ManyToMany
	List<TipoEstacoesAno> floracao;
	
	@ManyToOne
	String genero;
	
	@Enumerated(EnumType.STRING)
	@ManyToOne
	TipoRega rega;
	
	String tamanho;
	
	@ManyToOne
	Boolean perfumada;
	
	@ManyToOne
	String tribo;
	
	@ManyToOne
	String familia;
	
	@ManyToMany
	List<String> origem;
	
	@Enumerated(EnumType.STRING)
	@ManyToMany
	List<TipoPropagacao> propagacao;
	
	@ManyToOne
	String subFamilia;
	
	@Enumerated(EnumType.STRING)
	@OneToOne
	TipoCategoria categoria;
	
	@ManyToOne
	String subtribo;
	
	@OneToOne
	String especie;
	
	@Enumerated(EnumType.STRING)
	@ManyToMany
	List<TipoIluminacao> iluminacao;
	
	@Enumerated(EnumType.STRING)
	@ManyToMany
	List<TipoEstacoesAno> plantio;
	
	@OneToOne
	String texto;
	
	@ManyToOne
	Boolean frutoComestivel;

	public PlantDetails() {
		super();
	}

	public PlantDetails(
				String nome, List<String> 
				outrosNomes, 
				String ordem, 
				List<TipoEstacoesAno> floracao,
				String genero, 
				TipoRega rega, 
				String tamanho, 
				Boolean perfumada, 
				String tribo, 
				String familia,
				List<String> origem, 
				List<TipoPropagacao> propagacao, 
				String subFamilia, 
				TipoCategoria categoria,
				String subTribo, 
				String especie, 
				List<TipoIluminacao> iluminacao, 
				List<TipoEstacoesAno> plantio, 
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

	public List<String> getOutrosNomes() {
		return outrosNomes;
	}

	public void setOutrosNomes(List<String> outrosNomes) {
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

	public List<String> getOrigem() {
		return origem;
	}

	public void setOrigem(List<String> origem) {
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

	public int getCategoria() {
		return categoria.getValue();
	}

	public void setCategoria(TipoCategoria categoria) {
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

	public List<TipoIluminacao> getIluminacao() {
		return iluminacao;
	}

	public void setIluminacao(List<TipoIluminacao> iluminacao) {
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
