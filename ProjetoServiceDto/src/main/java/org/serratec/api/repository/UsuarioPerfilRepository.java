package org.serratec.api.repository;

import org.serratec.api.domain.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository	
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Long>{ 
	 																		// UsuarioPerfilPK = Sempre que tiver uma chave composta
																			// no Repository a chave primaria é o objeto primario 
																			// embeddable que está na entidade. Melhor forma = Serial

}
