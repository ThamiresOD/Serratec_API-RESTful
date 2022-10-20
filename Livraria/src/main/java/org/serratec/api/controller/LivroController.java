package org.serratec.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.api.domain.Livro;
import org.serratec.api.repository.LivroRepository;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	
//	@GetMapping
//	public ResponseEntity<List<UsuarioDTO>> listar() {
//		return ResponseEntity.ok(usuarioService.lista());
//	}
	
	@GetMapping
	public List<Livro> listar() {
		return livroRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um livro a partir do ID utilizado na url")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o livro correspondente ao ID"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 404, message = "Não foi possivel encontrar um livro correspondente ao ID"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação")
			
	})
	public ResponseEntity<Livro> buscar(@PathVariable Long id) {
	Optional<Livro> livro = livroRepository.findById(id);
	if (!livro.isPresent()) {
		return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(livro.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro inserir(@Valid @RequestBody Livro livro) {
		return livroRepository.save(livro);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id){
	if (!livroRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
	}
	livroRepository.deleteById(id);
	return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> alterar(@PathVariable Long id, 
	@Valid @RequestBody Livro livro){
	if (!livroRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
	}
	livro.setId(id);
	return ResponseEntity.ok(livroRepository.save(livro));
	}
}
