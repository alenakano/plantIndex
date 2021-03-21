package com.project.nakano.plantindex.jpa.model;

public enum TipoEstacoesAno {
  PRIMAVERA(1L),
  VERAO(2L),
  OUTONO(3L),
  INVERNO(4L),
  TODO(5L),
  SEM(6L);
  
  private final Long value;
  
  TipoEstacoesAno(Long value) {
    this.value = value;
  }
  
  public Long getValue() {
    return this.value;
  }
}
