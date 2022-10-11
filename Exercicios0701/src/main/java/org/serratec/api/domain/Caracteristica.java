package org.serratec.api.domain;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.serratec.api.enums.Categoria;
import org.serratec.api.enums.Combustivel;

@Embeddable
public class Caracteristica {

		private String renavam;
		private String chassi;
		private Long ano;
		
		@Enumerated(EnumType.STRING)
		private Categoria categoria;
		
		@Enumerated(EnumType.ORDINAL)
		private Combustivel combustivel;
}
