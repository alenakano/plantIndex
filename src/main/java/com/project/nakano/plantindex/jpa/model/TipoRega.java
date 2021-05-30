package com.project.nakano.plantindex.jpa.model;

import java.util.Optional;

public enum TipoRega implements ParseableEnum<TipoRega> {
  POUCA("pouca"),
  MEDIA("média"),
  MUITA("muita");
  
  private String rega;

  TipoRega(String rega) {
    this.setRega(rega);
  }

  public String getRega() {
    return rega;
  }

  public void setRega(String rega) {
    this.rega = rega;
  }
  
  @Override
  public Optional<String> getParsePattern() {
    return Optional.ofNullable(this.rega);
  }
  
}



