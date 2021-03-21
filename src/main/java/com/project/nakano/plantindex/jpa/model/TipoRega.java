package com.project.nakano.plantindex.jpa.model;

public enum TipoRega {
  POUCA(1L),
  MEDIA(2L),
  MUITA(3L);
  
  private long rega;

  TipoRega(long rega) {
    this.setRega(rega);
  }

  public long getRega() {
    return rega;
  }

  public void setRega(long rega) {
    this.rega = rega;
  }
}



