package org.serratec.api.repository;

import org.serratec.api.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {


}
