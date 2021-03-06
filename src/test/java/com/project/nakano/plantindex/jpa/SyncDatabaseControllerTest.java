package com.project.nakano.plantindex.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class SyncDatabaseControllerTest {
	  
	@Mock
	SyncDatabaseService syncDatabaseService;
	
	@InjectMocks
	SyncDatabaseController syncDatabaseController;
	
	@Test
	void test() throws Exception {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<?> responseEntity = new ResponseEntity<>(
		    "Sucesso",
		    header, 
		    HttpStatus.OK
		);
		
		doReturn(responseEntity).when(syncDatabaseService).syncDatabase(Mockito.anyString());
		
		assertThat(responseEntity.getStatusCode()).isEqualTo(syncDatabaseController.syncDatabase("test").getStatusCode());
	}

}
