package com.project.nakano.plantindex.jpa.model;

public enum TipoPropagacao {
  ESTACA(1L),
  TOUCEIRA(2L),
  MUDA(3L),
  SEMENTE(4L),
  BULBO(5L);
  
  private final Long value;
  
  TipoPropagacao(Long value) {
    this.value = value;
  }
  
  public Long getValue() {
    return this.value;
  }
}
