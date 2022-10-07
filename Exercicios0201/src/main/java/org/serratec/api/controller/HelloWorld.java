package org.serratec.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class HelloWorld {
	
	@RestController
	@RequestMapping("/api")
	public class OlaMundo {
		
		@GetMapping("/ola")
		public String olaMundo() {
			return "Ola Mundo!";
		}
		
		@GetMapping("/hello")
		public String helloWorld() {
			return "Hello World!";
		}
		
		@GetMapping("/maiuscula")
		public String maiuscula(@RequestParam String texto, @RequestParam String idade) {
			return texto.toUpperCase() + " - " + idade.toString();
		}
		
		@GetMapping("/tamanho")
		public Integer tamanho(@RequestParam String texto) {
			return texto.length();		
		}
	}
}
