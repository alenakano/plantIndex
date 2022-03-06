package com.project.nakano.plantindex.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import com.project.nakano.plantindex.jpa.model.Categoria;
import com.project.nakano.plantindex.jpa.model.Origem;
import com.project.nakano.plantindex.jpa.model.OutroNome;
import com.project.nakano.plantindex.jpa.model.PlantDetails;
import com.project.nakano.plantindex.jpa.model.TipoEstacoesAno;
import com.project.nakano.plantindex.jpa.model.TipoIluminacao;
import com.project.nakano.plantindex.jpa.model.TipoPropagacao;
import com.project.nakano.plantindex.jpa.model.TipoRega;

@ExtendWith(MockitoExtension.class)
class SyncDatabaseServiceTest {

	@Mock
	CategoriaRepository categoriaRepository;
	
	@Mock
	PlantRepository plantRepository;
	
	@Mock
	OutroNomeRepository outroNomeRepository;
	
	@Captor
	private ArgumentCaptor<PlantDetails> plantDetailsCaptor;
	
	@Mock
	OrigemRepository origemRepository;
	
	@Mock
	PlantDetailsFinder plantDetailsFinder;
	
	@Mock
	PlantNamesFinder plantNamesFinder;
	
	@Mock
	PlantDetailsBuilder plantDetailsBuilder;

	@InjectMocks
	SyncDatabaseService syncDatabaseService;
	
	List<String> namesPlant = new ArrayList<>();
	MultiValueMap<String, String> map = CollectionUtils.toMultiValueMap(new HashMap<>());
	PlantDetails plant = new PlantDetails();
	
	@BeforeEach
	void setup() throws IOException {	
		//Adicionando rotas
		namesPlant.add("/pimentao/");
		
		//Adicionando resposta do html
		map.add("Outros nomes", "pimentão-comum");
		map.add("Ordem", "Solanales");
		map.add("Floração", "o ano todo");
		map.add("Gênero", "Capsicum");
		map.add("Nome Popular", "pimentão");
		map.add("Rega", "muita água");
		map.add("Tamanho", "até 40 cm");
		map.add("Perfumada", "não");
		map.add("Tribo", "Capsiceae");
		map.add("Família", "Solanacea");
		map.add("Origem", "Américas");
		map.add("Propagação", "por muda");
		map.add("Subfamília", "Solanoideae");
		map.add("Categoria", "hortaliças");
		map.add("Subtribo", "-");
		map.add("Espécie", "Capiscum annuum");
		map.add("Iluminação", "meia sombra sombra");
		map.add("Plantio", "o ano todo");
		map.add("infos", "Teste");
		map.add("Frutos", "comestíveis");
		
		// Populando objeto
		List<OutroNome> outro = new ArrayList<>();
		outro.add(new OutroNome("pimentão-comum"));
		
		List<TipoEstacoesAno> flor = new ArrayList<>();
		flor.add(TipoEstacoesAno.TODO);
		
		List<Origem> or = new ArrayList<>();
		or.add(new Origem("Américas"));
		
		List<TipoPropagacao> prop = new ArrayList<>();
		prop.add(TipoPropagacao.MUDA);
		
		List<TipoIluminacao> ilu = new ArrayList<>();
		ilu.add(TipoIluminacao.SOMBRA);
		ilu.add(TipoIluminacao.MEIASOMBRA);
		
		List<TipoEstacoesAno> pla = new ArrayList<>();
		pla.add(TipoEstacoesAno.TODO);
		
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
	
	@Nested
	@DisplayName("Database")
	class databaseTest {
		@Nested
		@DisplayName("Save on Database")
		class saveTest {
			@BeforeEach
			void setup() throws IOException{
				given(plantNamesFinder.searchPlantNames(Mockito.anyString())).willReturn(namesPlant);
				given(plantDetailsFinder.searchPlantDetails("/pimentao/")).willReturn(map);
				given(plantDetailsBuilder.setRecoveredPlantDetails(map)).willReturn(plant);
			}
			
			@Test
			@DisplayName("Save OutroNome")
			public void newValueOutroNome() throws IOException {
				// WHEN
				syncDatabaseService.syncDatabase("teste");
				
				//THEN
				verify(outroNomeRepository, times(1)).findByNome("pimentão-comum");
				verify(outroNomeRepository, times(1)).save(Mockito.any(OutroNome.class));
			}
			
			@Test
			@DisplayName("Save Origem")
			public void newValueOrigem() throws IOException {
				// WHEN
				syncDatabaseService.syncDatabase("teste");
				//THEN
				verify(origemRepository, times(1)).findByNome("Américas");
				verify(origemRepository, times(1)).save(Mockito.any(Origem.class));
			}
			
			@Test
			@DisplayName("Save Categoria")
			public void newValueCategoria() throws IOException {
				// WHEN
				syncDatabaseService.syncDatabase("teste");
				
				//THEN
				verify(categoriaRepository, times(1)).findByNome("hortaliças");
				verify(categoriaRepository, times(1)).save(Mockito.any(Categoria.class));
			}
			
			@Test
			@DisplayName("Save Plant")
			public void testSuccessWithNewValuesOnDatabase() throws IOException {

				// WHEN
				ResponseEntity<?> res = syncDatabaseService.syncDatabase("teste");
				
				//THEN
				assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
				verify(plantRepository, times(1)).findByNome("Pimentão");
				verify(plantRepository, times(1)).save(Mockito.any(PlantDetails.class));
			}
		}
		@Nested
		@DisplayName("Update Database")
		class updateTest {
			@BeforeEach
			void setup() throws IOException {
				given(plantNamesFinder.searchPlantNames(Mockito.anyString())).willReturn(namesPlant);
				given(plantDetailsFinder.searchPlantDetails("/pimentao/")).willReturn(map);
				given(plantDetailsBuilder.setRecoveredPlantDetails(map)).willReturn(plant);

			}
			
			@Test
			@DisplayName("Update OutroNome")
			public void testUpdateOutroNome() throws IOException {
				//GIVEN
				OutroNome outroNomeTeste = new OutroNome("pimentão-comum");
				outroNomeTeste.setId(5L);		
				given(outroNomeRepository.findByNome("pimentão-comum")).willReturn(outroNomeTeste);
			
				// WHEN
				syncDatabaseService.syncDatabase("teste");
				
				//THEN

				// Atualizou OutroNome existente
				verify(outroNomeRepository, times(1)).findByNome("pimentão-comum");
				then(outroNomeRepository).should(times(1)).save(Mockito.any(OutroNome.class));
				
			}
			
			@Test
			@DisplayName("Update Origem")
			public void testUpdateOrigem() throws IOException {
				//GIVEN
				Origem origemTeste = new Origem("Américas");
				origemTeste.setId(10L);
				given(origemRepository.findByNome("Américas")).willReturn(origemTeste);
				
				// WHEN
				syncDatabaseService.syncDatabase("teste");			
				
				// THEN
				verify(origemRepository, times(1)).findByNome("Américas");
				then(origemRepository).should(times(1)).save(Mockito.any(Origem.class));
			}
			
			@Test
			@DisplayName("UpdateCategoria")
			public void testUpdateCategoria() throws IOException {
				//GIVEN
				Categoria categoriaTeste = new Categoria("hortaliças");
				categoriaTeste.setId(9L);
				given(categoriaRepository.findByNome("hortaliças")).willReturn(categoriaTeste);
				
				// WHEN
				syncDatabaseService.syncDatabase("teste");	
				
				// THEN
				then(categoriaRepository).should(times(1)).findByNome("hortaliças");
				then(categoriaRepository).should(times(1)).save(Mockito.any(Categoria.class));
			}
			
			@Test
			@DisplayName("Update Plant")
			public void testUpdatePlant() throws IOException {
				//GIVEN
				PlantDetails plantTeste = new PlantDetails(plant);
				plantTeste.setId(14L);
				given(plantRepository.findByNome("Pimentão")).willReturn(plantTeste);
				
				// WHEN
				ResponseEntity<?> res = syncDatabaseService.syncDatabase("teste");	
				
				// THEN
				then(plantRepository).should().save(plantDetailsCaptor.capture());
				assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
				// Atualizou Planta com dados existentes
				then(plantRepository).should(times(1)).save(Mockito.any(PlantDetails.class));
				assertThat(plantDetailsCaptor.getValue().getId()).isEqualTo(plantTeste.getId());
			}
		}	
	}
		
	@Nested
	@DisplayName("Exceptions")
	class exceptions {
		@Test
		@DisplayName("PlantNamesFinder Exception")
		public void testExceptionOnPlantNamesFinder() throws IOException {
			// GIVEN
			given(plantNamesFinder.searchPlantNames(Mockito.anyString())).willThrow(new IOException());
			
			// WHEN
			ResponseEntity<?> res = syncDatabaseService.syncDatabase("teste");
			
			//THEN
			assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

		@Test
		@DisplayName("PlantDetails Exception")
		public void testExceptionOnPlantDetails() throws IOException {
			
			// GIVEN
			given(plantNamesFinder.searchPlantNames(Mockito.anyString())).willReturn(namesPlant);
			given(plantDetailsFinder.searchPlantDetails(Mockito.any())).willThrow(new IOException());
			
			// WHEN
			ResponseEntity<?> res = syncDatabaseService.syncDatabase("teste");
			
			// THEN
			assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
			
		}
	}
	
}
