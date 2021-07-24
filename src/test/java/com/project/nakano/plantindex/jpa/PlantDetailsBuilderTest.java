package com.project.nakano.plantindex.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.nakano.plantindex.jpa.model.PlantDetails;

@ExtendWith(MockitoExtension.class)
class PlantDetailsBuilderTest {
	
	@InjectMocks
	PlantDetailsBuilder plantDetailsBuilder = new PlantDetailsBuilder();
	
	MultiValueMap<String, String> map;
	
	@BeforeEach
	void setup() {
		map = new MultiValueMap<>();
		map.put("Outros nomes", "pimentão-comum");
		map.put("Ordem", "Solanales");
		map.put("Floração", "o ano todo");
		map.put("Gênero", "Capsicum");
		map.put("Nome popular", "pimentão");
		map.put("Rega", "muita água");
		map.put("Tamanho", "até 40 cm");
		map.put("Perfumada", "não");
		map.put("Tribo", "Capsiceae");
		map.put("Família", "Solanacea");
		map.put("Origem", "Américas");
		map.put("Propagação", "muda");
		map.put("Subfamília", "Solanoideae");
		map.put("Categoria", "hortaliças");
		map.put("Subtribo", "-");
		map.put("Espécie", "Capiscum annuum");
		map.put("Iluminação", "meia sombra sombra");
		map.put("Plantio", "todo");
		map.put("infos", "Teste");
		map.put("Frutos", "comestíveis");
		
	}
	
	@Test
	void test() {
		PlantDetails plant = plantDetailsBuilder.setRecoveredPlantDetails(map);
		assertThat(plant).isNotNull();
	}

}
