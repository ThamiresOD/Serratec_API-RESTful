package org.serratec.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.api.domain.Proprietario;
import org.serratec.api.repository.ProprietarioRepository;
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
@RequestMapping("/Proprietario")
public class ProprietarioController {

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Proprietario inserir(@Valid @RequestBody Proprietario proprietario) {
		return proprietarioRepository.save(proprietario);
	}

	@GetMapping
	public List<Proprietario> listar() {
		return proprietarioRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Proprietario> buscar(@PathVariable Long id) {
		Optional<Proprietario> proprietario = proprietarioRepository.findById(id);
		if (!proprietario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(proprietario.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		if (!proprietarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		proprietarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Proprietario> alterar(@PathVariable Long id, @Valid @RequestBody Proprietario proprietario) {
		if (!proprietarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		proprietario.setId(id);
		return ResponseEntity.ok(proprietarioRepository.save(proprietario));
	}

}
