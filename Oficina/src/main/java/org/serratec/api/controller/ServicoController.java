package org.serratec.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.api.domain.Servico;
import org.serratec.api.repository.ServicoRepository;
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
@RequestMapping("/Servico")
public class ServicoController {

	@Autowired
	private ServicoRepository servicoRepository;

	@GetMapping
	public List<Servico> listar() {
		return servicoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Servico> buscar(@PathVariable Long id) {
		Optional<Servico> servico = servicoRepository.findById(id);
		if (!servico.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(servico.get());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico inserir(@Valid @RequestBody Servico servico) {
		return servicoRepository.save(servico);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		if (!servicoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		servicoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Servico> alterar(@PathVariable Long id, @Valid @RequestBody Servico servico) {
		if (!servicoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		servico.setId(id);
		return ResponseEntity.ok(servicoRepository.save(servico));
	}

}
