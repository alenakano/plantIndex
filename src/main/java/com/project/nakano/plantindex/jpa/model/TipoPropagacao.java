package com.project.nakano.plantindex.jpa.model;

public enum TipoPropagacao {
	ESTACA(0),
	TOUCEIRA(1),
	MUDA(2),
	SEMENTE(3),
	BULBO(4);
	
	private final int value;
	
	TipoPropagacao(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
