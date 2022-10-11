package org.serratec.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


	@RestController
	@RequestMapping("/api")
	public class veiculoController {
		
		@Autowired
		private veiculoRepository veiculoRepository;
		
		@GetMapping
		public List<veiculo> listar() {
			return veiculoRepository.findAll();
		}
		
		@GetMapping("/id")
		public ResponseEntity<veiculo> pesquisar(@PathVariable Long id) {
			Optional<veiculo> veiculo = veiculoRepository.findById(id);
			if (veiculo.isPresent()) {
				return ResponseEntity.ok(veiculo.get());
		}
		return ResponseEntity.notFound().build();
		}
		
		@PostMapping("/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public veiculo inserir(@Valid @RequestBody veiculo veiculo) {
			return veiculoRepository.save(veiculo);
		}
		
		@PutMapping
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<veiculo> atualizar(@PathVariable Long id,@Valid @RequestBody veiculo veiculo) {
			if (!veiculoRepository.existsById(id)) {
				return ResponseEntity.notFound().build();
			}
			veiculo.setId(id);
			veiculo = veiculoRepository.save(veiculo);
			return ResponseEntity.ok(veiculo);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> remover(@PathVariable Long id) {
			if (!veiculoRepository.existsById(id)) {
				return ResponseEntity.notFound().build();
			}
			veiculoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		 
	}
	

}
