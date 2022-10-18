package org.serratec.api.service;

import java.util.List;

import org.serratec.api.domain.Usuario;
import org.serratec.api.exception.EmailException;
import org.serratec.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> lista() {
		return usuarioRepository.findAll();
	}
	
	public Usuario inserir(Usuario usuario) {
		Usuario usuarioBanco = usuarioRepository.findByEmail(usuario.getEmail());
		if (usuarioBanco!=null) {
			throw new EmailException("Já existe um usuário com o e-mail" + usuario.getEmail());
		}
		return usuarioRepository.save(usuario);
	}
}
