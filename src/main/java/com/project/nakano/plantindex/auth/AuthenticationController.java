package com.project.nakano.plantindex.auth;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.JOSEException;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
  
  @Autowired
  TokenService tokenService;

  @PostMapping
  public ResponseEntity<TokenDTO> authenticate(@RequestBody Auth body) throws JOSEException, ParseException {
    System.out.println(body.getUser());
    
    
    this.tokenService.gerarToken(null);
    
    return ResponseEntity.ok(new TokenDTO());
  }
  
}