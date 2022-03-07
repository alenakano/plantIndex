package com.project.nakano.plantindex.auth;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
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

  // Faz spring recuperar da env do application.properties
  @Value("${auth.jwt.expiration}")
  private String expiration;

  // Faz spring recuperar da env do application.properties
  @Value("${auth.jwt.secret}")
  private String secret;

  public String gerarToken(Authentication authentication) throws JOSEException {

    User logado = (User) authentication.getPrincipal();
    Date hoje = new Date();
    // Soma data de hoje com tempo de expiração
    Date exp = new Date(hoje.getTime() + Long.parseLong(expiration));

    // Criando HMAC Signer com o secret
    JWSSigner signer = new MACSigner(secret);

    JWTClaimsSet claimsSet = new JWTClaimsSet.Builder().subject(logado.getId().toString()).expirationTime(exp)
        .issueTime(hoje).build();

    SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

    // Aplica a assinatura HMAC
    signedJWT.sign(signer);

    // Serializa para o formato conhecido do JWT (Separado por pontos e geralment em
    // base64)
    return signedJWT.serialize();
  }
}
