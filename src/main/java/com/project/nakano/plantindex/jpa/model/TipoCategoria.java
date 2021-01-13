package com.project.nakano.plantindex.jpa.model;

public enum TipoCategoria {
	
	AQUATICAS(1L),
	ARBUSTOS(2L),
	ARVORES(3L),
	BROMELIAS(4L),
	CACTOS(5L),
	FLORES(6L),
	FOLHAGENS(7L),
	FORRACOES(8L),
	FRUTIFERAS(9L),
	GRAOS(10L),
	HORTALICAS(11L),
	ORQUIDEAS(12L),
	PALMEIRAS(13L),
	PANCS(14L),
	SAMAMBAIAS(15L),
	SUCULENTAS(16L),
	TREPADEIRAS(17L);
	
	private final Long value;
	
	TipoCategoria(Long value){
		this.value = value;
	}
	
	public Long getValue(){
		return this.value;
	}
}
