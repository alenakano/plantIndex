package com.project.nakano.plantindex.jpa;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/syncdatabase")
public class SyncDatabaseController extends PlantDetailsBuilder {

  @Autowired
  SyncDatabaseService syncDatabaseService;
  
  @GetMapping()
  public ResponseEntity<?> syncDatabase(
      @RequestParam(value = "categoria", defaultValue = "") String categoria,
      @RequestParam(value = "keypass", defaultValue = "") String keypass
      )
      throws IOException {
    String pass = this.getKeyEnv();
    if (keypass.equals(pass)) {
      return this.syncDatabaseService.syncDatabase(categoria);      
    }
    return new ResponseEntity<>("Needs validation", HttpStatus.NO_CONTENT);
  }
  
  public String getKeyEnv() {
    return System.getenv("SyncKey");
  }

}
