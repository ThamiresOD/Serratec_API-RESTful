package org.serratec.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.api.domain.Categoria;
import org.serratec.api.dto.Categoria;
import org.serratec.api.dto.UsuarioInserirDTO;
import org.serratec.api.repository.CategoriaRepository;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
//	@GetMapping
//	public ResponseEntity<List<Categoria>> listar() {
//		return ResponseEntity.ok(categoriaService.lista());
//	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um categoria a partir do ID utilizado na url")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o categoria correspondente ao ID"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 404, message = "Não foi possivel encontrar um categoria correspondente ao ID"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação")
			
	})
	public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
	Optional<Categoria> categoria = categoriaRepository.findById(id);
	if (!categoria.isPresent()) {
		return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(categoria.get());
	}
	
	@PostMapping
	public ResponseEntity<Categoria> inserir(@RequestBody Categoria categoria) {
		categoria = categoriaRepository.save(categoria);
		URI uri = ServletUriComponentsBuilder 
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(categoria.getId())
				.toUri();
		return ResponseEntity.created(uri).body(categoria);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (!categoria.isPresent()) {
			return ResponseEntity.notFound().build();
		}
	categoriaRepository.deleteById(id);
	return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> alterar(@PathVariable Long id, 
	@Valid @RequestBody Categoria categoria){
	if (!categoriaRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
	}
	categoria.setId(id);
	return ResponseEntity.ok(categoriaRepository.save(categoria));
	}
}
