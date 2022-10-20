package org.serratec.api.controller;

import java.util.List;

import org.serratec.api.domain.Funcionario;
import org.serratec.api.dto.FuncionarioSalarioDTO;
import org.serratec.api.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping
	public ResponseEntity<Page<Funcionario>> listar(
			@PageableDefault(sort = "none", direction = Direction.ASC, size = 8, page = 3) Pageable pageable) {
		Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
		return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("/salario") 
	public ResponseEntity<Page<Funcionario>> listarSalarios( //Sempre deixar um valor default no parâmetro para não 
			@RequestParam(defaultValue = "0") Double valorMinimo, //dar erro caso o usuário não passe
			@RequestParam(defaultValue = "20") Double valorMaximo, Pageable pageable) {
		Page<Funcionario> funcionarios = funcionarioRepository.findBySalarioBetween(valorMinimo, valorMaximo, pageable);
	return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("/nome")
	public ResponseEntity<Page<Funcionario>> buscarPorNome(@RequestParam(defaultValue = "") String paramNome, Pageable pageable) {
		Page<Funcionario> funcionarios = funcionarioRepository.findByNomeContainingIgnoreCase(paramNome, pageable);
	return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("/salarios-por-idade")
	public ResponseEntity<List<FuncionarioSalarioDTO>> buscaSalariosPorIdade(){
	return ResponseEntity.ok(funcionarioRepository.buscaSalariosPorIdade());
	}

}
