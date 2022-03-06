package com.project.nakano.plantindex.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

@ExtendWith(MockitoExtension.class)
class PlantDetailsFinderTest {
	
	@Mock
	Connection connection;
	
	@Mock
	Document doc;
	
	@Mock
	Elements elements;
	
	@Mock
	Element element;
	
	@InjectMocks
	PlantDetailsFinder plantDetailsFinder;

	@Nested
	@DisplayName("Success")
	class success {
		@BeforeEach
		void setup() throws IOException {
			Elements mockedElementsA = new Elements();
			mockedElementsA.add(
				new Element("li")
					.addClass("A")
					.html("<span class=Label>teste</span><span class=Value>teste2</span>")
			);
			Elements mockedElementsB = new Elements();
			mockedElementsB.add(
				new Element("li")
					.addClass("B")
					.html("<span class=Label>teste3</span><span class=Value>teste4</span>")
			);		

			given(connection.get()).willReturn(doc);
			given(doc.select(Mockito.anyString())).willReturn(elements);
			given(elements.last()).willReturn(element);
			given(elements.remove()).willReturn(elements);
			given(doc.select("li.A")).willReturn(mockedElementsA);
			given(doc.select("li.B")).willReturn(mockedElementsB);
		}

		@Test
		@DisplayName("Saves map")
		void successCategoryMultiplePages() throws IOException {
			// GIVEN
			PlantDetailsFinder plant = new PlantDetailsFinder();
			PlantDetailsFinder spyPlant = Mockito.spy(plant);
			Mockito.doReturn(connection).when(spyPlant).connect(Mockito.any());
			
			// WHEN
		  MultiValueMap<String, String> map = spyPlant.searchPlantDetails("/teste");
			
			//THEN
			MultiValueMap<String, String>  result = CollectionUtils.toMultiValueMap(new HashMap<>());
			result.add("teste", "teste2");
			result.add("teste3", "teste4");
			result.add("infos", "elements");
			
			assertThat(map).isEqualTo(result);
		}
	}
	
	@Nested
	@DisplayName("Http Error")
	class error {

		@Test
		@DisplayName("Throws Error")
		void test() throws IOException {
			// GIVEN
			PlantDetailsFinder plant = new PlantDetailsFinder();
			PlantDetailsFinder spyPlant = Mockito.spy(plant);
			doReturn(connection).when(spyPlant).connect(Mockito.any());
			doThrow(new HttpStatusException("TESTE", 500, "/rotaTeste")).when(connection).get();
			
			// WHEN
			MultiValueMap<String, String> map = spyPlant.searchPlantDetails("/teste");

			// THEN
			assertThat(map).isEmpty();
		}
	}

}
