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

public class PlantDetailsBuilder {
	
	PlantDetails setRecoveredPlantDetails(MultiValueMap<String, String> map) {
		
		String nome = this.extractStringFromMap(map, "Nome popular");

		List<OutroNome> outrosNomes = this.outroNomeParser((ArrayList<String>) map.getCollection("Outros nomes"));

		String ordem = this.extractStringFromMap(map, "Ordem");

		List<TipoEstacoesAno> floracao = this.floracaoParser(this.extractStringFromMap(map, "Floração"));

		String genero = this.extractStringFromMap(map, "Gênero");

		TipoRega rega = this.regaParser(this.extractStringFromMap(map, "Rega")).get(0);

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
	
	private List<TipoRega> regaParser(String rega) {
	  EnumParser<TipoRega> enumParser = new EnumParser<>(TipoRega.class, rega);
    return enumParser.getListEnum();
	}

	private List<TipoEstacoesAno> floracaoParser(String floracao) {
	  EnumParser<TipoEstacoesAno> enumParser = new EnumParser<>(TipoEstacoesAno.class, floracao);
    return enumParser.getListEnum();
	}
	
	private List<TipoEstacoesAno> plantioParser(String plantios) {
	  EnumParser<TipoEstacoesAno> plantio = new EnumParser<>(TipoEstacoesAno.class, plantios);
	  return plantio.getListEnum();
	}

	private Boolean setPerfumada(String perfumada) {
		return perfumada.contains("sim");
	}

	private Boolean setFrutoComestivel(String frutos) {
		return frutos.matches("^comestíveis$");
	}

	private List<TipoIluminacao> iluminacaoParser(String iluminacao) {
	  iluminacao = iluminacao.replace("meia sombra", "meiasombra");
	  EnumParser<TipoIluminacao> enumParser = new EnumParser<>(TipoIluminacao.class, iluminacao);
	  return enumParser.getListEnum();
	}

	private List<TipoPropagacao> propagacaoParser(String propagacao) {
    EnumParser<TipoPropagacao> enumParser = new EnumParser<>(TipoPropagacao.class, propagacao);
    return enumParser.getListEnum();
	}
	
}
