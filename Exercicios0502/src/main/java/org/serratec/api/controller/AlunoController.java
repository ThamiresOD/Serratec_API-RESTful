package org.serratec.api.controller;

import java.util.List;

import org.serratec.api.domain.Aluno;
import org.serratec.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
//	@GetMapping("/{matricula}")
//	public Aluno buscar(@PathVariable Long matricula) {
//		return lista.stream().filter(a -> a.getMatricula().equals(matricula)).findFirst().orElse(null);
//	}
//	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED) 
//	public Aluno inserir(@RequestBody Aluno aluno) {
//		lista.add(aluno);
//		return aluno;
//	}
//	
//	@DeleteMapping("/{matricula}")
//	public void delete(@PathVariable Long matricula) {
//		for (int i = 0; i< lista.size(); i++) {
//			if (lista.get(i).getMatricula().equals(matricula)) {
//			lista.remove(i);
//			break;
//			}
//		}
//	}
//	
//	@PutMapping("/{matricula}")
//	public Aluno atualizar(@RequestBody Aluno aluno, @PathVariable Long matricula) {
//		for (int i = 0; i < lista.size(); i++) {
//			if (lista.get(i).getMatricula().equals(matricula)) {
//				Aluno a = new Aluno(matricula, aluno.getNome(), aluno.getTelefone());
//				lista.set(i, a);
//				return a;
//			}
//		}
//		return null;
//	}
}
