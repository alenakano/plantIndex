package com.project.nakano.plantindex.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.lang3.StringUtils;

import com.project.nakano.plantindex.jpa.model.Categoria;
import com.project.nakano.plantindex.jpa.model.Floracao;
import com.project.nakano.plantindex.jpa.model.Iluminacao;
import com.project.nakano.plantindex.jpa.model.Origem;
import com.project.nakano.plantindex.jpa.model.OutroNome;
import com.project.nakano.plantindex.jpa.model.PlantDetails;
import com.project.nakano.plantindex.jpa.model.Plantio;
import com.project.nakano.plantindex.jpa.model.Propagacao;
import com.project.nakano.plantindex.jpa.model.TipoCategoria;
import com.project.nakano.plantindex.jpa.model.TipoEstacoesAno;
import com.project.nakano.plantindex.jpa.model.TipoIluminacao;
import com.project.nakano.plantindex.jpa.model.TipoPropagacao;
import com.project.nakano.plantindex.jpa.model.TipoRega;

public abstract class PlantDetailsBuilder {
	
	PlantDetails setRecoveredPlantDetails(MultiValueMap<String, String> map) {
		String nome = this.extractStringFromMap(map, "Nome popular");

		List<OutroNome> outrosNomes = this.outroNomeParser((ArrayList<String>) map.getCollection("Outros nomes"));

		String ordem = this.extractStringFromMap(map, "Ordem");

		List<Floracao> floracao = this.floracaoParser(this.extractStringFromMap(map, "Floração"));

		String genero = this.extractStringFromMap(map, "Gênero");

		TipoRega rega = this.regaParser(this.extractStringFromMap(map, "Rega"));

		String tamanho = this.extractStringFromMap(map,"Tamanho");

		Boolean perfumada = this.setPerfumada(this.extractStringFromMap(map, "Perfumada"));

		String tribo = this.extractStringFromMap(map, "Tribo");

		String familia = this.extractStringFromMap(map,"Família");

		List<Origem> origem = this.origemParser((ArrayList<String>) map.getCollection("Origem"));
	
		List<Propagacao> propagacao = this.propagacaoParser(this.extractStringFromMap(map, "Propagação"));

		String subFamilia = this.extractStringFromMap(map, "Subfamília");

		Categoria categoria = this.categoriaParser(this.extractStringFromMap(map, "Categoria"));

		String subTribo = this.extractStringFromMap(map, "Subtribo");

		String especie = this.extractStringFromMap(map, "Espécie");

		List<Iluminacao> iluminacao = this.iluminacaoParser(this.extractStringFromMap(map, "Iluminação"));
	
		List<Plantio> plantio = this.plantioParser(this.extractStringFromMap(map, "Plantio"));

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

	private List<Floracao> floracaoParser(String estText) {
		List<Floracao> floracao = new ArrayList<>();
		if (estText.contains("primavera"))
			floracao.add(new Floracao(TipoEstacoesAno.PRIMAVERA.getValue(), TipoEstacoesAno.PRIMAVERA));
		if (estText.contains("verão"))
			floracao.add(new Floracao(TipoEstacoesAno.VERAO.getValue(), TipoEstacoesAno.VERAO));
		if (estText.contains("outono"))
			floracao.add(new Floracao(TipoEstacoesAno.OUTONO.getValue(), TipoEstacoesAno.OUTONO));
		if (estText.contains("inverno"))
			floracao.add(new Floracao(TipoEstacoesAno.INVERNO.getValue(), TipoEstacoesAno.INVERNO));
		if (estText.contains("todo"))
			floracao.add(new Floracao(TipoEstacoesAno.ANOTODO.getValue(), TipoEstacoesAno.ANOTODO));
		if (estText.contains("sem"))
			floracao.add(new Floracao(TipoEstacoesAno.SEM.getValue(), TipoEstacoesAno.SEM));

		return floracao;
	}
	
	private List<Plantio> plantioParser(String estText) {
		List<Plantio> plantio = new ArrayList<>();
		if (estText.contains("primavera"))
			plantio.add(new Plantio(TipoEstacoesAno.PRIMAVERA.getValue(), TipoEstacoesAno.PRIMAVERA));
		if (estText.contains("verão"))
			plantio.add(new Plantio(TipoEstacoesAno.VERAO.getValue(), TipoEstacoesAno.VERAO));
		if (estText.contains("outono"))
			plantio.add(new Plantio(TipoEstacoesAno.OUTONO.getValue(), TipoEstacoesAno.OUTONO));
		if (estText.contains("inverno"))
			plantio.add(new Plantio(TipoEstacoesAno.INVERNO.getValue(), TipoEstacoesAno.INVERNO));
		if (estText.contains("todo"))
			plantio.add(new Plantio(TipoEstacoesAno.ANOTODO.getValue(), TipoEstacoesAno.ANOTODO));
		if (estText.contains("sem"))
			plantio.add(new Plantio(TipoEstacoesAno.SEM.getValue(), TipoEstacoesAno.SEM));

		return plantio;
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
