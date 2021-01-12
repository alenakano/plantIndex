package com.project.nakano.plantindex.jpa.model;

public enum TipoEstacoesAno {
	PRIMAVERA(1),
	VERAO(2),
	OUTONO(3),
	INVERNO(4),
	ANOTODO(5),
	SEM(6);
	
	private final int value;
	
	TipoEstacoesAno(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
