package com.project.nakano.plantindex.model;

public enum CategoriaEnum {
	
	AQUATICAS(1),
	ARBUSTOS(2),
	ARVORES(3),
	BROMELIAS(4),
	CACTOS(5),
	FLORES(6),
	FOLHAGENS(7),
	FORRACOES(8),
	FRUTIFERAS(9),
	GRAOS(10),
	HORTALICAS(11),
	ORQUIDEAS(12),
	PALMEIRAS(13),
	PANCS(14),
	SAMAMBAIAS(15),
	SUCULENTAS(16),
	TREPADEIRAS(17);
	
	private final int value;
	
	CategoriaEnum(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
