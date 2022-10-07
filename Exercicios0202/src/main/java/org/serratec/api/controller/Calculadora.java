package org.serratec.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Calculadora {
	
	//Segunda Forma:
	/*
	@Autowired
	CalculadoraService calculadoraService;

	@GetMapping("/soma/{n1}/{n2}")
	public Double soma(@PathVariable Double n1, @PathVariable Double n2) {
		Double resultado = calculadoraService.soma(n1, n2);
		return resultado;
	}
	
	@GetMapping("/subtracao/{n1}/{n2}")
	public Double subtracao(@PathVariable Double n1, @PathVariable Double n2) {
		Double resultado = calculadoraService.subtracao(n1, n2);
		return resultado;
	}
	
	@GetMapping("/divisao/{n1}/{n2}")
	public Double divisao(@PathVariable Double n1, @PathVariable Double n2) {
		Double resultado = calculadoraService.divisao(n1, n2);
		return resultado;
	}
	
	@GetMapping("/multiplicacao/{n1}/{n2}")
	public Double multiplicacao(@PathVariable Double n1, @PathVariable Double n2) {
		Double resultado = calculadoraService.multiplicacao(n1, n2);
		return resultado;
	}
	*/
	
	//Primeira Forma:
	
	@GetMapping("/soma")
	public Double soma(@RequestParam Double n1, @RequestParam Double n2) {
		return n1 + n2;
	}
	@GetMapping("/subtracao")
	public Double subtracao(@RequestParam Double n1, @RequestParam Double n2) {
		return n1 - n2;
	}
	@GetMapping("/multiplicacao")
	public Double multiplicacao(@RequestParam Double n1, @RequestParam Double n2) {
		return n1 * n2;
	}
	@GetMapping("/divisao")
	public Double divisao(@RequestParam Double n1, @RequestParam Double n2) {
		return n1 / n2;
	}
	
}

