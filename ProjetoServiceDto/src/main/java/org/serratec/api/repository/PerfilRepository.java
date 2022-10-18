package org.serratec.api.repository;

import org.serratec.api.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository	
public interface PerfilRepository extends JpaRepository<Perfil, Long>{

}
