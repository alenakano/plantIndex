package com.project.nakano.plantindex.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.nakano.plantindex.jpa.model.Categoria;
import com.project.nakano.plantindex.jpa.model.Origem;
import com.project.nakano.plantindex.jpa.model.OutroNome;
import com.project.nakano.plantindex.jpa.model.PlantDetails;
import com.project.nakano.plantindex.jpa.model.TipoEstacoesAno;
import com.project.nakano.plantindex.jpa.model.TipoIluminacao;
import com.project.nakano.plantindex.jpa.model.TipoPropagacao;
import com.project.nakano.plantindex.jpa.model.TipoRega;

// MockitoExtension -> Compatível JUnit 5
//@ExtendWith(MockitoExtension.class)
//A partir do Spring 2.1, Não é mais necessário o ExtendWith
@SpringBootTest
class SyncDatabaseServiceTest {

	@Mock
	CategoriaRepository categoriaMock;
	
	@Mock
	PlantRepository plantMock;
	
	@Mock
	OutroNomeRepository outroMock;
	
	@Captor
	private ArgumentCaptor<PlantDetails> plantDetailsCaptor;
	
	@Mock
	OrigemRepository origemMock;
	
	@Mock
	PlantDetailsFinder plantDetailsFinder;
	
	@Mock
	PlantNamesFinder plantNamesFinder;
	
	@Mock
	PlantDetailsBuilder plantDetailsBuilder;
	

	@InjectMocks
	SyncDatabaseService syncDatabaseService;
	
	List<String> namesPlant = new ArrayList<>();
	MultiValueMap<String, String> map = new MultiValueMap<String, String>();
	PlantDetails plant;
	
	// GIVEN
	@BeforeEach
	void setup() throws IOException {
		//Adicionando rotas
		namesPlant.add("/pimentao/");
		
		//Adicionando resposta do html
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
		
		// Populando objeto
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
		
		plant = new PlantDetails(
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
	}
	
	@Test
	public void testSuccessWithNewValuesOnDatabase() throws IOException {

		// WHEN
		when(plantNamesFinder.searchPlantNames(Mockito.anyString())).thenReturn(namesPlant);
		when(plantDetailsFinder.searchPlantDetails("/pimentao/")).thenReturn(map);
		when(plantDetailsBuilder.setRecoveredPlantDetails(map)).thenReturn(plant);
		
		ResponseEntity<?> res = syncDatabaseService.syncDatabase("teste");
		
		//THEN
		assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
		verify(outroMock, times(1)).findByNome("pimentão-comum");
		verify(outroMock, times(1)).save(Mockito.any(OutroNome.class));
		verify(origemMock, times(1)).findByNome("Américas");
		verify(origemMock, times(1)).save(Mockito.any(Origem.class));
		verify(categoriaMock, times(1)).findByNome("hortaliças");
		verify(categoriaMock, times(1)).save(Mockito.any(Categoria.class));
		verify(plantMock, times(1)).findByNome("Pimentão");
		verify(plantMock, times(1)).save(Mockito.any(PlantDetails.class));
	}
	
	@Test
	public void testSuccessExistentValuesOnDatabase() throws IOException {
		
		//GIVEN
		OutroNome outroNomeTeste = new OutroNome("pimentão-comum");
		outroNomeTeste.setId(5L);
		
		Origem origemTeste = new Origem("Américas");
		origemTeste.setId(10L);
		
		Categoria categoriaTeste = new Categoria("hortaliças");
		categoriaTeste.setId(9L);
		
		PlantDetails plantTeste = new PlantDetails(plant);
		plantTeste.setId(14L);

		// WHEN
		when(plantNamesFinder.searchPlantNames(Mockito.anyString())).thenReturn(namesPlant);
		when(plantDetailsFinder.searchPlantDetails("/pimentao/")).thenReturn(map);
		when(plantDetailsBuilder.setRecoveredPlantDetails(map)).thenReturn(plant);
		when(plantMock.findByNome("Pimentão")).thenReturn(plantTeste);
		when(outroMock.findByNome("pimentão-comum")).thenReturn(outroNomeTeste);
		when(origemMock.findByNome("Américas")).thenReturn(origemTeste);
		when(categoriaMock.findByNome("hortaliças")).thenReturn(categoriaTeste);
		
		ResponseEntity<?> res = syncDatabaseService.syncDatabase("teste");
		
		//THEN
		
		// Captura valor salvo ao chamar o método
		verify(plantMock).save(plantDetailsCaptor.capture());
		
		assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		// Atualizou OutroNome existente
		verify(outroMock, times(1)).findByNome("pimentão-comum");
		verify(outroMock, times(0)).save(Mockito.any(OutroNome.class));

		
		// Atualizou Origem existente
		verify(origemMock, times(1)).findByNome("Américas");
		verify(origemMock, times(0)).save(Mockito.any(Origem.class));
		
		// Atualizou Categoria existente
		verify(categoriaMock, times(1)).findByNome("hortaliças");
		verify(categoriaMock, times(0)).save(Mockito.any(Categoria.class));

		// Atualizou Planta com dados existentes
		verify(plantMock, times(1)).save(Mockito.any(PlantDetails.class));
		assertThat(plantDetailsCaptor.getValue().getId()).isEqualTo(plantTeste.getId());
		
	}
	
	@Test
	public void testExceptionOnPlantNamesFinder() throws IOException {
		// WHEN
		when(plantNamesFinder.searchPlantNames(Mockito.anyString())).thenThrow(new IOException());
		
		ResponseEntity<?> res = syncDatabaseService.syncDatabase("teste");
		
		//THEN
		assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	@Test
	public void testExceptionOnPlantDetails() throws IOException {
		
		// WHEN
		when(plantNamesFinder.searchPlantNames(Mockito.anyString())).thenReturn(namesPlant);
		when(plantDetailsFinder.searchPlantDetails(Mockito.any())).thenThrow(new IOException());
		
		
		ResponseEntity<?> res = syncDatabaseService.syncDatabase("teste");
		
		// THEN
		assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	}
}
