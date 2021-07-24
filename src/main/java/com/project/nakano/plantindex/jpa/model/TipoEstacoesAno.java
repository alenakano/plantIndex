package com.project.nakano.plantindex.jpa.model;

import java.util.Optional;

public enum TipoEstacoesAno implements ParseableEnum<TipoEstacoesAno> {
  PRIMAVERA("primavera"),
  VERAO("verão"),
  OUTONO("outono"),
  INVERNO("inverno"),
  TODO("o ano todo"),
  SEM("sem");

  private String parsePattern;
  
  TipoEstacoesAno(String parsePattern) {
    this.parsePattern = parsePattern;
  }
 
  public String parseString() {
    return this.parsePattern;
  }

  @Override
  public Optional<String> getParsePattern() {
    return Optional.ofNullable(this.parsePattern);
  }
}
