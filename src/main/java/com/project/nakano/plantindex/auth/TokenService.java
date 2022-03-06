package com.project.nakano.plantindex.auth;

import java.util.Date;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@Service
public class TokenService {
  
   //Faz spring recuperar da env do application.properties
   @Value("${auth.jwt.expiration}")
   private String expiration;
  
   // Faz spring recuperar da env do application.properties
   @Value("${auth.jwt.secret}")
   private String secret;
  
   public String gerarToken(Authentication authentication) throws JOSEException {
    
//     Usuario logado = (Usuario) authentication.getPrincipal();
     Date hoje = new Date();
     // Soma data de hoje com tempo de expiração
     Date exp = new Date(hoje.getTime() + Long.parseLong(expiration));

     // Create HMAC signer
     JWSSigner signer = new MACSigner("testandotestandotestandotestando");
     JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
         .subject("alice")
         .issuer("https://c2id.com")
         .expirationTime(exp)
         .build();
       
      SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
   
      // Apply the HMAC protection
      signedJWT.sign(signer);
     
      // Serialize to compact form, produces something like
      // eyJhbGciOiJIUzI1NiJ9.SGVsbG8sIHdvcmxkIQ.onO9Ihudz3WkiauDO2Uhyuz0Y18UASXlSc1eS0NkWyA
      String s = signedJWT.serialize();
    
      System.out.println(s);
      
      return "OK";
     
   }
}
