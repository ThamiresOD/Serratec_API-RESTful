package org.serratec.api.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.api.domain.Aluno;
import org.serratec.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	public AlunoController(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
		alunoRepository.save(new Aluno(1000L, "Romin", "2356-5623"));
		alunoRepository.save(new Aluno(1001L, "Thata", "4578-7845"));
		alunoRepository.save(new Aluno(1002L, "Violet", "8956-5689"));
	}

	@GetMapping
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}

	@GetMapping("/{matricula}")
	public ResponseEntity<Aluno> buscaAluno(@PathVariable Long matricula) {
		Optional<Aluno> aluno = alunoRepository.findById(matricula);
		if (aluno.isEmpty()) {
			return ResponseEntity.notFound().header("x-data-exclusão", "01/01/2001").build();
		}
		return ResponseEntity.ok(aluno.get());
	}

//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public Aluno inserir(@RequestBody Aluno aluno) {
//		return alunoRepository.save(aluno);
//	}

	@PostMapping
	public ResponseEntity<Aluno> inserir(@RequestBody Aluno aluno) {
		Aluno alunoBanco = alunoRepository.save(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoBanco);
	}

	@PutMapping("/{matricula}")
	public ResponseEntity<Aluno> atualizar(@PathVariable Long matricula, @RequestBody Aluno aluno) {
		Optional<Aluno> alunoOptional = alunoRepository.findById(matricula);
		if (alunoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Aluno alunoBanco = alunoOptional.get();
		alunoBanco.setNome(aluno.getNome());
		alunoBanco.setTelefone(aluno.getTelefone());
		alunoBanco = alunoRepository.save(alunoBanco);
		return ResponseEntity.ok(alunoBanco);
	}
}
