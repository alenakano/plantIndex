package com.project.nakano.plantindex.jpa.model;

import java.util.Optional;

public enum TipoPropagacao implements ParseableEnum<TipoPropagacao> {
  ESTACA("estaca"),
  TOUCEIRA("touceira"),
  MUDA("muda"),
  SEMENTE("semente"),
  BULBO("bulbo");
  
  private final String value;
  
  TipoPropagacao(String value) {
    this.value = value;
  }
  
  public String getValue() {
    return this.value;
  }
  
  @Override
  public Optional<String> getParsePattern() {
    return Optional.ofNullable(this.value);
  }
}
