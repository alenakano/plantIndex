package com.project.nakano.plantindex.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import com.project.nakano.plantindex.jpa.model.PlantDetails;

@ExtendWith(MockitoExtension.class)
class PlantDetailsBuilderTest {
	
	@InjectMocks
	PlantDetailsBuilder plantDetailsBuilder = new PlantDetailsBuilder();
	
	MultiValueMap<String, String> map;
	
	@BeforeEach
	void setup() {
		map = CollectionUtils.toMultiValueMap(new HashMap<>());
		map.add("Outros nomes", "pimentão-comum");
		map.add("Ordem", "Solanales");
		map.add("Floração", "o ano todo");
		map.add("Gênero", "Capsicum");
		map.add("Nome popular", "pimentão");
		map.add("Rega", "muita água");
		map.add("Tamanho", "até 40 cm");
		map.add("Perfumada", "não");
		map.add("Tribo", "Capsiceae");
		map.add("Família", "Solanacea");
		map.add("Origem", "Américas");
		map.add("Propagação", "muda");
		map.add("Subfamília", "Solanoideae");
		map.add("Categoria", "hortaliças");
		map.add("Subtribo", "-");
		map.add("Espécie", "Capiscum annuum");
		map.add("Iluminação", "meia sombra sombra");
		map.add("Plantio", "todo");
		map.add("infos", "Teste");
		map.add("Frutos", "comestíveis");
		
	}
	
	@Test
	void test() {
		PlantDetails plant = plantDetailsBuilder.setRecoveredPlantDetails(map);
		assertThat(plant).isNotNull();
	}

}
