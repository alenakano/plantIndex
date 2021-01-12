package com.project.nakano.plantindex.jpa.model;

public enum TipoIluminacao {
	SOMBRA(0),
	MEIASOMBRA(1),
	SOLPLENO(2);
	
	private final int value;
	
	TipoIluminacao(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
