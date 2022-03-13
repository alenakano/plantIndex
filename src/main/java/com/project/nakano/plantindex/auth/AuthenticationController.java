package com.project.nakano.plantindex.auth;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.JOSEException;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  private static final String TOKEN_TYPE = "Bearer";

  @Autowired
  TokenService tokenService;

  /*
   * Só consegue fazer isso porque realizamos seu Bean na classe
   * SecurityConfigurations.
   */
  @Autowired
  private AuthenticationManager authManager;

  @PostMapping
  public ResponseEntity<TokenDTO> authenticate(@RequestBody Auth body) throws JOSEException, ParseException, IOException {

    UsernamePasswordAuthenticationToken authenticationData = body.convertToAuthenticationToken();

    try {
      Authentication auth = authManager.authenticate(authenticationData);
      return ResponseEntity.ok(new TokenDTO(this.tokenService.gerarToken(auth), TOKEN_TYPE));
    } catch (AuthenticationException e) {
      System.out.println(e);
      return ResponseEntity.badRequest().build();
    }

  }

}