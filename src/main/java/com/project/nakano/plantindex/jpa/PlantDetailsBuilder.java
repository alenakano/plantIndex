package com.project.nakano.plantindex.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.lang3.StringUtils;

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
	  System.out.println(map.toString());
		
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
	  return new EnumParser<>(TipoRega.class, this.formatString(rega)).getListEnum();
	}

	private List<TipoEstacoesAno> floracaoParser(String floracao) {
	  return new EnumParser<>(TipoEstacoesAno.class, this.formatString(floracao)).getListEnum();
	}
	
	private List<TipoEstacoesAno> plantioParser(String plantios) {
	  return new EnumParser<>(TipoEstacoesAno.class, this.formatString(plantios)).getListEnum();
	}

	private Boolean setPerfumada(String perfumada) {
		return perfumada.contains("sim");
	}

	private Boolean setFrutoComestivel(String frutos) {
		return frutos.matches("^comestíveis$");
	}

	private List<TipoIluminacao> iluminacaoParser(String iluminacao) {
	  return new EnumParser<>(TipoIluminacao.class, this.formatString(iluminacao)).getListEnum();
	}

	private List<TipoPropagacao> propagacaoParser(String propagacao) {
    return new EnumParser<>(TipoPropagacao.class, this.formatString(propagacao)).getListEnum();
	}
	
	private String formatString(String field) {
	  // Remover conectores
	  Pattern conectors = Pattern.compile("^o\\s|^por|\\s+(o|da|de|por|e por|e)\\s+|,", Pattern.CANON_EQ);
	  field = conectors.matcher(field).replaceAll(" ");
	  
	  // Remover palavras não utilizadas
	  Pattern words = Pattern.compile("divisão|água|ano|pleno", Pattern.CANON_EQ);
	  field = words
	      .matcher(field)
	      .replaceAll(" ")
	      .trim()
	      .replaceAll("\\s+", " ");
	  // Retorna sem acento e maiúscula
	  return StringUtils.stripAccents(field.toUpperCase());
	}
	
//	public static void main(String[] args) {
//	  PlantDetailsBuilder planta = new PlantDetailsBuilder();
//	  String teste = "o ano todo";
//	  String teste2 = "por muda e por semente";
//    String teste3 = "por bulbo, por divisão de touceira e por semente";
//    String teste4 = "por divisão de touceira, por estaca e por semente";
//    String teste5 = "muita água";
//    String teste6 = "meia sombra sombra sol pleno";
//    System.out.println(planta.formatString(teste));
//    System.out.println(planta.formatString(teste2));
//    System.out.println(planta.formatString(teste3));
//    System.out.println(planta.formatString(teste4));
//    System.out.println(planta.formatString(teste5));
//    System.out.println(planta.formatString(teste6));
//  }
}
