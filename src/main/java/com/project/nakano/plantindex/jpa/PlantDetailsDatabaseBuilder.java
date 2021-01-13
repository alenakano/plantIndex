package com.project.nakano.plantindex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.lang3.StringUtils;

import com.project.nakano.plantindex.jpa.model.Categoria;
import com.project.nakano.plantindex.jpa.model.EstacoesAno;
import com.project.nakano.plantindex.jpa.model.Iluminacao;
import com.project.nakano.plantindex.jpa.model.Origem;
import com.project.nakano.plantindex.jpa.model.OutroNome;
import com.project.nakano.plantindex.jpa.model.PlantDetails;
import com.project.nakano.plantindex.jpa.model.Propagacao;
import com.project.nakano.plantindex.jpa.model.TipoCategoria;
import com.project.nakano.plantindex.jpa.model.TipoEstacoesAno;
import com.project.nakano.plantindex.jpa.model.TipoIluminacao;
import com.project.nakano.plantindex.jpa.model.TipoPropagacao;
import com.project.nakano.plantindex.jpa.model.TipoRega;

public abstract class PlantDetailsDatabaseBuilder {
	
	PlantDetails setRecoveredPlantDetails(MultiValueMap<String, String> map) {
		String nome = ((ArrayList<String>) map.get("Nome popular")).get(0);

		List<OutroNome> outrosNomes = this.outroNomeParser((ArrayList<String>) map.get("Outros nomes"));

		String ordem = ((ArrayList<String>) map.get("Ordem")).get(0);

		List<EstacoesAno> floracao = this.estacoesAnoParser(((ArrayList<String>) map.get("Floração")).get(0));

		String genero = ((ArrayList<String>) map.get("Gênero")).get(0);

		TipoRega rega = this.regaParser(((ArrayList<String>) map.get("Rega")).get(0));

		String tamanho = ((ArrayList<String>) map.get("Tamanho")).get(0);

		Boolean perfumada = this.setPerfumada(((ArrayList<String>) map.get("Perfumada")).get(0));

		String tribo = ((ArrayList<String>) map.get("Tribo")).get(0);

		String familia = ((ArrayList<String>) map.get("Família")).get(0);

		List<Origem> origem = this.origemParser((ArrayList<String>) map.get("Origem"));
	
		List<Propagacao> propagacao = this.propagacaoParser(((ArrayList<String>) map.get("Propagação")).get(0));

		String subFamilia = ((ArrayList<String>) map.get("Subfamília")).get(0);

		Categoria categoria = this.categoriaParser(((ArrayList<String>) map.get("Categoria")).get(0));

		String subTribo = ((ArrayList<String>) map.get("Subtribo")).get(0);

		String especie = ((ArrayList<String>) map.get("Espécie")).get(0);

		List<Iluminacao> iluminacao = this.iluminacaoParser(((ArrayList<String>) map.get("Iluminação")).get(0));
	
		List<EstacoesAno> plantio = this.estacoesAnoParser(((ArrayList<String>) map.get("Plantio")).get(0));

		String infos = ((ArrayList<String>) map.get("infos")).get(0);

		Boolean frutoComestivel = setFrutoComestivel(((ArrayList<String>) map.get("Frutos")).get(0));

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

	private List<OutroNome> outroNomeParser(ArrayList<String> outrosNomes) {

		List<OutroNome> names = new ArrayList<>();
		if (outrosNomes != null && !outrosNomes.isEmpty()) {
			outrosNomes.forEach(s -> {
				String[] namesSplitted = s.split(", ");
				for (String name : namesSplitted) {
					names.add(new OutroNome(name));
				}
			});
		} else {
			names.add(new OutroNome("nenhum"));
		}
		return names;
	}

	private List<Origem> origemParser(ArrayList<String> origem) {

		List<Origem> names = new ArrayList<>();
		if (origem != null && !origem.isEmpty()) {
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

	private List<EstacoesAno> estacoesAnoParser(String estText) {
		List<EstacoesAno> floracao = new ArrayList<>();
		if (estText.contains("primavera"))
			floracao.add(new EstacoesAno(TipoEstacoesAno.PRIMAVERA.getValue(), TipoEstacoesAno.PRIMAVERA));
		if (estText.contains("verão"))
			floracao.add(new EstacoesAno(TipoEstacoesAno.VERAO.getValue(), TipoEstacoesAno.VERAO));
		if (estText.contains("outono"))
			floracao.add(new EstacoesAno(TipoEstacoesAno.OUTONO.getValue(), TipoEstacoesAno.OUTONO));
		if (estText.contains("inverno"))
			floracao.add(new EstacoesAno(TipoEstacoesAno.INVERNO.getValue(), TipoEstacoesAno.INVERNO));
		if (estText.contains("todo"))
			floracao.add(new EstacoesAno(TipoEstacoesAno.ANOTODO.getValue(), TipoEstacoesAno.ANOTODO));
		if (estText.contains("sem"))
			floracao.add(new EstacoesAno(TipoEstacoesAno.SEM.getValue(), TipoEstacoesAno.SEM));

		return floracao;
	}

	public Categoria categoriaParser(String cat) {
		TipoCategoria categoria = TipoCategoria.valueOf(StringUtils.stripAccents(cat).replace("[", "").replace("]", "").toUpperCase());
		return new Categoria(categoria.getValue(), categoria);
	}

	private Boolean setPerfumada(String per) {
		return per.contains("sim");
	}

	private Boolean setFrutoComestivel(String fru) {
		return fru.matches("^comestíveis$");
	}

	private List<Iluminacao> iluminacaoParser(String ilu) {
		List<Iluminacao> iluminacao = new ArrayList<>();

		if (ilu.contains("meia"))
			iluminacao.add(new Iluminacao(TipoIluminacao.MEIASOMBRA.getValue(), TipoIluminacao.MEIASOMBRA));
		if (ilu.contains("sol"))
			iluminacao.add(new Iluminacao(TipoIluminacao.SOLPLENO.getValue(), TipoIluminacao.SOLPLENO));
		if (ilu.contains("meia sombra sombra"))
			iluminacao.add(new Iluminacao(TipoIluminacao.SOMBRA.getValue(), TipoIluminacao.SOMBRA));
		return iluminacao;
	}

	private List<Propagacao> propagacaoParser(String pro) {
		List<Propagacao> propagacao = new ArrayList<>();
		if (pro.contains("bulbo"))
			propagacao.add(new Propagacao(TipoPropagacao.BULBO.getValue(), TipoPropagacao.BULBO));
		if (pro.contains("estaca"))
			propagacao.add(new Propagacao(TipoPropagacao.ESTACA.getValue(), TipoPropagacao.ESTACA));
		if (pro.contains("muda"))
			propagacao.add(new Propagacao(TipoPropagacao.MUDA.getValue(), TipoPropagacao.MUDA));
		if (pro.contains("semente"))
			propagacao.add(new Propagacao(TipoPropagacao.SEMENTE.getValue(), TipoPropagacao.SEMENTE));
		if (pro.contains("touceira"))
			propagacao.add(new Propagacao(TipoPropagacao.TOUCEIRA.getValue(), TipoPropagacao.TOUCEIRA));
		return propagacao;
	}
	
}
