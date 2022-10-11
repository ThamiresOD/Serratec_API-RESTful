package org.serratec.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.api.domain.Veiculo;
import org.serratec.api.repository.VeiculoRepository;
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
	public class VeiculoController {
	
		@Autowired
		private VeiculoRepository veiculoRepository;
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Veiculo inserir(@Valid @RequestBody Veiculo veiculo) {
			return veiculoRepository.save(veiculo);
		}
		
		@GetMapping
		public List<Veiculo> listar() {
			return veiculoRepository.findAll();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Veiculo> buscar(@PathVariable Long id) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(id);
		if (!veiculo.isPresent()) {
		return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(veiculo.get());
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Void> apagar(@PathVariable Long id){
		if (!veiculoRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
		}
		veiculoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<Veiculo> alterar(@PathVariable Long id, 
		@Valid @RequestBody Veiculo veiculo){
		if (!veiculoRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
		}
		veiculo.setId(id);
		return ResponseEntity.ok(veiculoRepository.save(veiculo));
		}
		
	

}
