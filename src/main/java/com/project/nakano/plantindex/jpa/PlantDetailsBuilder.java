package com.project.nakano.plantindex.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.map.MultiValueMap;

import com.project.nakano.plantindex.jpa.model.Categoria;
import com.project.nakano.plantindex.jpa.model.Origem;
import com.project.nakano.plantindex.jpa.model.OutroNome;
import com.project.nakano.plantindex.jpa.model.PlantDetails;
import com.project.nakano.plantindex.jpa.model.TipoEstacoesAno;
import com.project.nakano.plantindex.jpa.model.TipoIluminacao;
import com.project.nakano.plantindex.jpa.model.TipoPropagacao;
import com.project.nakano.plantindex.jpa.model.TipoRega;

public abstract class PlantDetailsBuilder {
	
	PlantDetails setRecoveredPlantDetails(MultiValueMap<String, String> map) {
		String nome = this.extractStringFromMap(map, "Nome popular");

		List<OutroNome> outrosNomes = this.outroNomeParser((ArrayList<String>) map.getCollection("Outros nomes"));

		String ordem = this.extractStringFromMap(map, "Ordem");

		List<TipoEstacoesAno> floracao = this.floracaoParser(this.extractStringFromMap(map, "Floração"));

		String genero = this.extractStringFromMap(map, "Gênero");

		TipoRega rega = this.regaParser(this.extractStringFromMap(map, "Rega"));

		String tamanho = this.extractStringFromMap(map,"Tamanho");

		Boolean perfumada = this.setPerfumada(this.extractStringFromMap(map, "Perfumada"));

		String tribo = this.extractStringFromMap(map, "Tribo");

		String familia = this.extractStringFromMap(map,"Família");

		List<Origem> origem = this.origemParser((ArrayList<String>) map.getCollection("Origem"));
	
		List<TipoPropagacao> propagacao = this.propagacaoParser(this.extractStringFromMap(map, "Propagação"));

		String subFamilia = this.extractStringFromMap(map, "Subfamília");

		Categoria categoria = new Categoria(this.extractStringFromMap(map, "Categoria"));

		String subTribo = this.extractStringFromMap(map, "Subtribo");

		String especie = this.extractStringFromMap(map, "Espécie");

		List<TipoIluminacao> iluminacao = this.iluminacaoParser(this.extractStringFromMap(map, "Iluminação"));
	
		List<TipoEstacoesAno> plantio = this.plantioParser(this.extractStringFromMap(map, "Plantio"));

		String infos = this.extractStringFromMap(map, "infos");

		Boolean frutoComestivel = setFrutoComestivel(this.extractStringFromMap(map, "Frutos"));

		return new PlantDetails(
					nome,
					outrosNomes,
					ordem,
					floracao,
					genero,
					rega,
					tamanho,
					perfumada,
					tribo,
					familia,
					origem,
					propagacao,
					subFamilia,
					categoria,
					subTribo,
					especie,
					iluminacao,
					plantio,
					infos,
					frutoComestivel
				);
	}
	
	private String extractStringFromMap(MultiValueMap<String, String> map, String key) {
		return map.getCollection(key).toArray(new String[0])[0];
	}

	private List<OutroNome> outroNomeParser(ArrayList<String> outrosNomes) {

		List<OutroNome> names = new ArrayList<>();
		if (!Objects.isNull(outrosNomes)) {
			outrosNomes.forEach(s -> {
				String[] namesSplitted = s.split(", ");
				for (String name : namesSplitted) {
					if (!name.isEmpty()) { 
						names.add(new OutroNome(name));
					} else {
						names.add(new OutroNome("nenhum"));
					}
				}
			});
		} else {
			names.add(new OutroNome("nenhum"));
		}
		return names;
	}

	private List<Origem> origemParser(ArrayList<String> origem) {

		List<Origem> names = new ArrayList<>();
		if (!Objects.isNull(origem)) {
			origem.forEach(s -> {
				String[] namesSplitted = s.replace(" e ", ", ").split(", ");
				for (String name : namesSplitted) {
					names.add(new Origem(name));
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

	private List<TipoEstacoesAno> floracaoParser(String estText) {
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
	
	private List<TipoEstacoesAno> plantioParser(String estText) {
		List<TipoEstacoesAno> plantio = new ArrayList<>();
		if (estText.contains("primavera"))
			plantio.add(TipoEstacoesAno.PRIMAVERA);
		if (estText.contains("verão"))
			plantio.add(TipoEstacoesAno.VERAO);
		if (estText.contains("outono"))
			plantio.add(TipoEstacoesAno.OUTONO);
		if (estText.contains("inverno"))
			plantio.add(TipoEstacoesAno.INVERNO);
		if (estText.contains("todo"))
			plantio.add(TipoEstacoesAno.ANOTODO);
		if (estText.contains("sem"))
			plantio.add(TipoEstacoesAno.SEM);

		return plantio;
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
