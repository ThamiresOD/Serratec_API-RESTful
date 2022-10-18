package org.serratec.api.controller;

import java.net.URI;
import java.util.List;

import org.serratec.api.dto.UsuarioDTO;
import org.serratec.api.dto.UsuarioInserirDTO;
import org.serratec.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listar() {
		return ResponseEntity.ok(usuarioService.lista());
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> inserir(@RequestBody UsuarioInserirDTO usuarioInserirDTO) {
		UsuarioDTO usuario = usuarioService.inserir(usuarioInserirDTO);
		URI uri = ServletUriComponentsBuilder //Boa prática utilizar o URI
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
	
}
