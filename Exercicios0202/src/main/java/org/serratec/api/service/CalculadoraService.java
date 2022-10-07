package org.serratec.api.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

	public Double soma(Double n1, Double n2) {
		return n1 + n2;
	}
	
	public Double subtracao(Double n1, Double n2) {
		return n1 - n2;
	}
	
	public Double multiplicacao(Double n1, Double n2) {
		return n1 * n2;
	}
	
	public Double divisao(Double n1, Double n2) {
		return n1 / n2;
	}
}
