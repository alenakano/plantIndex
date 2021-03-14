package com.project.nakano.plantindex.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class SyncDatabaseControllerTest {
	  
	@Mock
	SyncDatabaseService syncDatabaseService;
	
	@InjectMocks
	SyncDatabaseController syncDatabaseController;
	
	@Test
	@DisplayName("Call Service")
	void test() throws Exception {
		
		// GIVEN
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		// WHEN
		ResponseEntity<?> responseEntity = new ResponseEntity<>(
		    "Sucesso",
		    header, 
		    HttpStatus.OK
		);
		
		// THEN
		doReturn(responseEntity).when(syncDatabaseService).syncDatabase(Mockito.anyString());
		assertThat(responseEntity.getStatusCode()).isEqualTo(syncDatabaseController.syncDatabase("test").getStatusCode());
	}
}
