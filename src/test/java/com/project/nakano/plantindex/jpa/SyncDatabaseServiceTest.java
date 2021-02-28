package com.project.nakano.plantindex.jpa;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.project.nakano.plantindex.jpa.model.Categoria;
import com.project.nakano.plantindex.jpa.model.Origem;
import com.project.nakano.plantindex.jpa.model.OutroNome;
import com.project.nakano.plantindex.jpa.model.PlantDetails;
import com.project.nakano.plantindex.jpa.model.TipoEstacoesAno;
import com.project.nakano.plantindex.jpa.model.TipoIluminacao;
import com.project.nakano.plantindex.jpa.model.TipoPropagacao;
import com.project.nakano.plantindex.jpa.model.TipoRega;

@RunWith(MockitoJUnitRunner.class)
public class SyncDatabaseServiceTest {

	@Mock
	CategoriaRepository categoriaMock;
	
	@Mock
	PlantRepository plantMock;
	
	@Mock
	OutroNomeRepository outroMock;
	
	@Mock
	OrigemRepository origemMock;
	
	@Mock
	private PlantDetailsFinder plantDetailsFinder;
	
	@Mock
	private PlantNamesFinder plantNamesFinder;
	
	@Mock
	private PlantDetailsBuilder plantDetailsBuilder;
	
	
	private SyncDatabaseService syncDatabaseService = 
			new SyncDatabaseService();
	
	@Test
	void testSuccess() throws IOException {
		//Given
		List<String> name = new ArrayList<String>();
		name.add("/pimentao/");

		MultiValueMap<String, String> map = new MultiValueMap<String, String>();
		map.put("Outros nomes", "pimentão-comum");
		map.put("Ordem", "Solanales");
		map.put("Floração", "o ano todo");
		map.put("Gênero", "Capsicum");
		map.put("Nome Popular", "pimentão");
		map.put("Rega", "muita água");
		map.put("Tamanho", "até 40 cm");
		map.put("Perfumada", "não");
		map.put("Tribo", "Capsiceae");
		map.put("Família", "Solanacea");
		map.put("Origem", "Américas");
		map.put("Propagação", "por muda");
		map.put("Subfamília", "Solanoideae");
		map.put("Categoria", "hortaliças");
		map.put("Subtribo", "-");
		map.put("Espécie", "Capiscum annuum");
		map.put("Iluminação", "meia sombra sombra");
		map.put("Plantio", "o ano todo");
		map.put("infos", "Teste");
		map.put("Frutos", "comestíveis");
		
		
		List<OutroNome> outro = new ArrayList<>();
		outro.add(new OutroNome("pimentão-comum"));
		
		List<TipoEstacoesAno> flor = new ArrayList<>();
		flor.add(TipoEstacoesAno.ANOTODO);
		
		List<Origem> or = new ArrayList<>();
		or.add(new Origem("Américas"));
		
		List<TipoPropagacao> prop = new ArrayList<>();
		prop.add(TipoPropagacao.MUDA);
		
		List<TipoIluminacao> ilu = new ArrayList<>();
		ilu.add(TipoIluminacao.SOMBRA);
		ilu.add(TipoIluminacao.MEIASOMBRA);
		
		List<TipoEstacoesAno> pla = new ArrayList<>();
		pla.add(TipoEstacoesAno.ANOTODO);
		
		Categoria cat = new Categoria("hortaliças");
		
		PlantDetails plant = 
			new PlantDetails(
					"Pimentão",
					outro,
					"Solanales",
					flor,
					"Solanales",
					TipoRega.MUITA,
					"até 40 cm",
					true,
					"Capsiceae",
					"Solanacea",
					or, 
					prop,
					"Solanoideae",
					cat,
					"-",
					"Capiscum annuum",
					ilu,
					pla,
					"Teste",
					true
			);
		
		//When
		
		ResponseEntity<?> res = syncDatabaseService.syncDatabase("teste");
		when(plantNamesFinder.searchPlantNames("teste")).thenReturn(name);
		when(plantDetailsFinder.searchPlantDetails("/pimentao/")).thenReturn(map);
		when(plantDetailsBuilder.setRecoveredPlantDetails(map)).thenReturn(plant);
		
		
		//Then
//		Assert.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	}

}
