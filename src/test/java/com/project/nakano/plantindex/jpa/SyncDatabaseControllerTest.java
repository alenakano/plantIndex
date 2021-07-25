package com.project.nakano.plantindex.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

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
		SyncDatabaseController syncTest = spy(syncDatabaseController);
		when(syncTest.getKeyEnv()).thenReturn("plantIndex");
		ResponseEntity<?> responseEntity = new ResponseEntity<>(
		    "Sucesso",
		    header, 
		    HttpStatus.OK
		);
		
		// THEN
		doReturn(responseEntity).when(syncDatabaseService).syncDatabase(Mockito.anyString());
		assertThat(responseEntity.getStatusCode()).isEqualTo(syncTest.syncDatabase("teste1", "plantIndex").getStatusCode());
	}
	
	@Test
  @DisplayName("Call Service without env")
  void testWithouEnv() throws Exception {
    
    // GIVEN
    HttpHeaders header = new HttpHeaders();
    header.setContentType(MediaType.APPLICATION_JSON);
    

    // WHEN
    SyncDatabaseController syncTest = spy(syncDatabaseController);
    when(syncTest.getKeyEnv()).thenReturn("plantIndex2");
    ResponseEntity<?> responseEntity = new ResponseEntity<>(
        "Sucesso",
        header, 
        HttpStatus.NO_CONTENT
    );
    
    // THEN
    assertThat(responseEntity.getStatusCode()).isEqualTo(syncTest.syncDatabase("teste1", "plantIndex").getStatusCode());
  }
}
