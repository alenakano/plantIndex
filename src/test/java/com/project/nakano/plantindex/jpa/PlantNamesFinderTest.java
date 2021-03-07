package com.project.nakano.plantindex.jpa;

import static org.mockito.Mockito.when;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//@SpringBootTest
//@RunWith(PowerMockRunner.class)
@ExtendWith(MockitoExtension.class)
class PlantNamesFinderTest {
	
	@Mock
	Connection connection;
	
	@Mock
	Response response;

	@InjectMocks
	PlantNamesFinder plantNamesFinder;
	
	private final String URL = "https://minhasplantas.com.br/plantas/categorias/teste?page=1&querystring_key=page";
	 
	@Test
	void test() throws IOException {
		
//		 new MockUp<Jsoup>() {
//	        public Connection connect() {
//	            return connection;
//	        }
//		 };
		 
		 Document doc = new Document("TESTE");
		 
		 when(Jsoup.connect(URL).get()).thenReturn(doc);
		 
	//
	//		PlantNamesFinder plantNamesFinder = new PlantNamesFinder();
		plantNamesFinder.searchPlantNames("teste");
			
	//		assertNull(res);
	}
}
