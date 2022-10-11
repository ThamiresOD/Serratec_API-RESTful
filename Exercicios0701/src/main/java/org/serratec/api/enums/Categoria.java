package org.serratec.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Categoria {
	HATCH,SEDAN,PICAPE,SUV,CONVERSIVEL,MINIVAN;
	
	@JsonCreator
	public static Categoria verifica(String value) throws EnumValidationException {
		for(Categoria c: values()) {
			if (value.equals(c.name())) {
				return c;
			}
		}
		throw new EnumValidationException("Categoria preenchida incorretamente"); 
	}
}
