package com.project.nakano.plantindex.jpa.model;

import java.util.Optional;

public enum TipoIluminacao implements ParseableEnum<TipoIluminacao> {
	SOMBRA("sombra"),
	MEIASOMBRA("(?<!meia )sombra"),
	SOL("sol pleno");
	
	private final String value;
	
	TipoIluminacao(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
  @Override
  public Optional<String> getParsePattern() {
    return Optional.ofNullable(this.value);
  }

}
