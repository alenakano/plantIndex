package com.project.nakano.plantindex.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

@ExtendWith(MockitoExtension.class)
class PlantNamesFinderTest {
	
	@Mock
	Connection connection;
	
	@Mock
	Document doc;
	
	@InjectMocks
	PlantNamesFinder plantNamesFinder;

	@Nested
	@DisplayName("Success")
	class success {
		@BeforeEach
		void setup() throws IOException {
			Elements mockedElements = new Elements();
			mockedElements.add(new Element("a").attr("href", "teste"));
			given(doc.select(Mockito.anyString())).willReturn(mockedElements);
			given(connection.get()).willReturn(doc);
		}

		@Test
		@DisplayName("With argument and multiple pages")
		void successCategoryMultiplePages() throws IOException {
			// GIVEN
			PlantNamesFinder plant = new PlantNamesFinder();
			PlantNamesFinder spyPlant = Mockito.spy(plant);
			Mockito.doReturn(connection).when(spyPlant).connect(Mockito.any());
			given(doc.getElementsByClass(Mockito.anyString())).willReturn(new Elements(new Element("a").addClass("endless_more")));
			
			// WHEN
			List<String> planta = spyPlant.searchPlantNames("teste");
			
			//THEN
			List<String> result = new ArrayList<>();
			for(int i = 0; i < 20; i++) {
				result.add("teste");
			}
			
			assertThat(planta).isEqualTo(result);
		}
		
		@Test
		@DisplayName("With argument and one page")
		void successCategoryOnePage() throws IOException {
			// GIVEN
			PlantNamesFinder plant = new PlantNamesFinder();
			PlantNamesFinder spyPlant = Mockito.spy(plant);
			Mockito.doReturn(connection).when(spyPlant).connect(Mockito.any());
			given(doc.getElementsByClass(Mockito.anyString())).willReturn(new Elements());
			
			// WHEN
			List<String> planta = spyPlant.searchPlantNames("teste");
			
			//THEN
			List<String> result = new ArrayList<>();
			result.add("teste");
			assertThat(planta).isEqualTo(result);
		}

	}
	
	@Nested
	@DisplayName("Http Error")
	class error {

		@Test
		@DisplayName("Throws Error")
		void test() throws IOException {
			// GIVEN
			PlantNamesFinder plant = new PlantNamesFinder();
			PlantNamesFinder spyPlant = Mockito.spy(plant);
			doReturn(connection).when(spyPlant).connect(Mockito.any());
			doThrow(new HttpStatusException("TESTE", 500, "/rotaTeste")).when(connection).get();
			
			// WHEN
			List<String> planta = spyPlant.searchPlantNames("teste");

			// THEN
			assertThat(planta).isEmpty();
		}
	}
	
	
	
}
