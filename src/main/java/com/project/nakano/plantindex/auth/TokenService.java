package com.project.nakano.plantindex.auth;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.ECDSAVerifier;
import com.nimbusds.jwt.JWTClaimsSet;

@Service
public class TokenService {

  @Autowired
  ECKeyManager ecKeyManager;
  
  // Faz spring recuperar da env do application.properties
  @Value("${auth.jwt.expiration}")
  private String expiration;

  public String gerarToken(Authentication authentication) throws JOSEException, IOException, ParseException {
    
    User logado = (User) authentication.getPrincipal();
    Date hoje = new Date();

    // Soma data de hoje com tempo de expiração
    Date exp = new Date(hoje.getTime() + Long.parseLong(expiration));
    
    // Montagem dos claims
    JWTClaimsSet claimsSet = new JWTClaimsSet.Builder().subject(logado.getId().toString()).expirationTime(exp)
        .issueTime(hoje).claim("name", logado.getName()).build();

    JWSSigner signer = new ECDSASigner(this.ecKeyManager.getECKeyManager());
    
    JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.ES256), claimsSet.toPayload());

    jwsObject.sign(signer);
    
    return jwsObject.serialize();
  }
  
  public boolean validarToken(JWSObject jws) throws JOSEException, IOException {
    JWSVerifier verifier = new ECDSAVerifier(this.ecKeyManager.getECKeyManager().toECPublicKey());
    return jws.verify(verifier);
  }
}
