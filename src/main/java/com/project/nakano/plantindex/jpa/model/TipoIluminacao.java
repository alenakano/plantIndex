package com.project.nakano.plantindex.jpa.model;

public enum TipoIluminacao {
	SOMBRA(1L),
	MEIASOMBRA(2L),
	SOLPLENO(3L);
	
	private final Long value;
	
	TipoIluminacao(Long value){
		this.value = value;
	}
	
	public Long getValue(){
		return this.value;
	}
}
