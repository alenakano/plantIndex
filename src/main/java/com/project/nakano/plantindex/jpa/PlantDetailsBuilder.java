package com.project.nakano.plantindex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.lang3.StringUtils;

import com.project.nakano.plantindex.jpa.model.TipoCategoria;
import com.project.nakano.plantindex.jpa.model.TipoEstacoesAno;
import com.project.nakano.plantindex.jpa.model.TipoIluminacao;
import com.project.nakano.plantindex.jpa.model.PlantDetails;
import com.project.nakano.plantindex.jpa.model.TipoPropagacao;
import com.project.nakano.plantindex.jpa.model.TipoRega;

public abstract class PlantDetailsBuilder {

	public PlantDetails setRecoveredPlantDetails(MultiValueMap<String, String> map) {

		String nome = ((ArrayList<String>) map.get("Nome popular")).get(0);

		List<String> outrosNomes = this.arrayParser((ArrayList<String>) map.get("Outros nomes"));

		String ordem = ((ArrayList<String>) map.get("Ordem")).get(0);

		List<TipoEstacoesAno> floracao = this.estacoesAnoParser(((ArrayList<String>) map.get("Floração")).get(0));

		String genero = ((ArrayList<String>) map.get("Gênero")).get(0);

		TipoRega rega = this.regaParser(((ArrayList<String>) map.get("Rega")).get(0));

		String tamanho = ((ArrayList<String>) map.get("Tamanho")).get(0);

		Boolean perfumada = this.setPerfumada(((ArrayList<String>) map.get("Perfumada")).get(0));

		String tribo = ((ArrayList<String>) map.get("Tribo")).get(0);

		String familia = ((ArrayList<String>) map.get("Família")).get(0);

		List<String> origem = this.arrayParser((ArrayList<String>) map.get("Origem"));

		List<TipoPropagacao> propagacao = this.propagacaoParser(((ArrayList<String>) map.get("Propagação")).get(0));

		String subFamilia = ((ArrayList<String>) map.get("Subfamília")).get(0);

		TipoCategoria categoria = this.categoriaParser(((ArrayList<String>) map.get("Categoria")).get(0));

		String subTribo = ((ArrayList<String>) map.get("Subtribo")).get(0);

		String especie = ((ArrayList<String>) map.get("Espécie")).get(0);

		List<TipoIluminacao> iluminacao = this.iluminacaoParser(((ArrayList<String>) map.get("Iluminação")).get(0));

		List<TipoEstacoesAno> plantio = this.estacoesAnoParser(((ArrayList<String>) map.get("Plantio")).get(0));

		String infos = ((ArrayList<String>) map.get("infos")).get(0);

		Boolean frutoComestivel = setFrutoComestivel(((ArrayList<String>) map.get("Frutos")).get(0));

		return new PlantDetails(nome, outrosNomes, ordem, floracao, genero, rega, tamanho, perfumada, tribo, familia,
				origem, propagacao, subFamilia, categoria, subTribo, especie, iluminacao, plantio, infos,
				frutoComestivel);
	}

	private List<String> arrayParser(ArrayList<String> outrosNomes) {

		List<String> names = new ArrayList<>();
		if (outrosNomes != null) {
			outrosNomes.forEach(s -> {
				String[] namesSplitted = s.split(", ");
				for (String name : namesSplitted) {
					names.add(name);
				}
			});
		}
		return names;
	}

	private TipoRega regaParser(String rega) {
		if (rega.contains("pouca"))
			return TipoRega.POUCA;
		if (rega.contains("muita"))
			return TipoRega.MUITA;
		return TipoRega.MEDIA;
	}

	private List<TipoEstacoesAno> estacoesAnoParser(String estText) {
		List<TipoEstacoesAno> floracao = new ArrayList<>();
		if (estText.contains("primavera"))
			floracao.add(TipoEstacoesAno.PRIMAVERA);
		if (estText.contains("verão"))
			floracao.add(TipoEstacoesAno.VERAO);
		if (estText.contains("outono"))
			floracao.add(TipoEstacoesAno.OUTONO);
		if (estText.contains("inverno"))
			floracao.add(TipoEstacoesAno.INVERNO);
		if (estText.contains("todo"))
			floracao.add(TipoEstacoesAno.ANOTODO);
		if (estText.contains("sem"))
			floracao.add(TipoEstacoesAno.SEM);

		return floracao;
	}

	private TipoCategoria categoriaParser(String cat) {
		return TipoCategoria.valueOf(StringUtils.stripAccents(cat).replace("[", "").replace("]", "").toUpperCase());
	}

	private Boolean setPerfumada(String per) {
		return per.contains("sim");
	}

	private Boolean setFrutoComestivel(String fru) {
		return fru.matches("^comestíveis$");
	}

	private List<TipoIluminacao> iluminacaoParser(String ilu) {
		List<TipoIluminacao> iluminacao = new ArrayList<>();

		if (ilu.contains("meia"))
			iluminacao.add(TipoIluminacao.MEIASOMBRA);
		if (ilu.contains("sol"))
			iluminacao.add(TipoIluminacao.SOLPLENO);
		if (ilu.contains("meia sombra sombra"))
			iluminacao.add(TipoIluminacao.SOMBRA);

		return iluminacao;
	}

	private List<TipoPropagacao> propagacaoParser(String pro) {
		List<TipoPropagacao> propagacao = new ArrayList<>();

		if (pro.contains("bulbo"))
			propagacao.add(TipoPropagacao.BULBO);
		if (pro.contains("estaca"))
			propagacao.add(TipoPropagacao.ESTACA);
		if (pro.contains("muda"))
			propagacao.add(TipoPropagacao.MUDA);
		if (pro.contains("semente"))
			propagacao.add(TipoPropagacao.SEMENTE);
		if (pro.contains("touceira"))
			propagacao.add(TipoPropagacao.TOUCEIRA);
		return propagacao;
	}

}
