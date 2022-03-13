package com.project.nakano.plantindex.auth;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWKSet;

@Component
public class ECKeyManager {
  
  private Optional<ECKey> ECKey = Optional.empty();
  
  private final String EC_KEY_PATH = "src/main/resources/ECKey.json";

  // Faz spring recuperar da env do application.properties
  @Value("${auth.jwt.secretId}")
  private String secretId;

  // Faz spring recuperar da env do application.properties
  @Value("${auth.jwt.ec}")
  private String ecKeyContent;

  @PostConstruct
  public void init() {
    try {
      File ecFile = new File(EC_KEY_PATH);
      if (!ecFile.canRead()) {
        try (FileWriter ecWriter = new FileWriter(ecFile)) {
          ecWriter.write(this.ecKeyContent);          
        }
      }
      
      JWKSet jwkSet = JWKSet.load(new File(EC_KEY_PATH));
      this.ECKey = Optional.ofNullable(jwkSet.getKeyByKeyId(this.secretId).toECKey());
    
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    } 
  }
  
  public ECKey getECKeyManager() throws IOException {
    if (this.ECKey.isPresent()) {
      return ECKey.get();
    } else {
      throw new IOException("Não foi possível ler o arquivo");
    }
  }
}
