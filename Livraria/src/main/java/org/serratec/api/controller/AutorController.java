package org.serratec.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.api.domain.Autor;
import org.serratec.api.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@GetMapping
	public ResponseEntity<List<Autor>> buscar() {
		return ResponseEntity.ok(autorRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Autor> buscarPorId(@PathVariable Long id) {
		Optional<Autor> autor = autorRepository.findById(id);
		if (!autor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(autor.get());
	}

	@PostMapping
	public ResponseEntity<Autor> inserir(@Valid @RequestBody Autor autor) {
		autor = autorRepository.save(autor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId())
				.toUri();
		return ResponseEntity.created(uri).body(autor);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Autor> atualizar(@PathVariable Long id, @Valid @RequestBody Autor autor) {
		Optional<Autor> autorBanco = autorRepository.findById(id);
		if (!autorBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		autor.setId(id);
		autor = autorRepository.save(autor);
		return ResponseEntity.ok(autor);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<Autor> autorBanco = autorRepository.findById(id);
		if (!autorBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		autorRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
