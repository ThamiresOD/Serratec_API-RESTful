package org.serratec.api.repository;

import java.util.List;

import org.serratec.api.domain.Funcionario;
import org.serratec.api.dto.FuncionarioSalarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	@Query("SELECT f FROM Funcionario f where f.salario>= :valorMinimo AND f.salario <= :valorMaximo")
	Page<Funcionario> buscarSalario(Double valorMinimo, Double valorMaximo, Pageable pageable);
	
	@Query("SELECT f FROM Funcionario f WHERE UPPER(f.nome) like UPPER(CONCAT('%', :paramNome, '%'))")
	Page<Funcionario> buscarPorNome(String paramNome, Pageable pageable);

	@Query(value = "select date_part('year',age(now(), data_nascimento)) as idade, " +
			" round(avg(salario).2) as mediaSalario, " +
			" min(salario) as menorSalario, " +
			" max(salario) as maiorSalario, " +
			" count(*) as totalFuncionarios " +
			" from funcionario " +
			" group by idade " +
			" having count(*)>1 " +
			" order by idade desc ", nativeQuery = true)
			List<FuncionarioSalarioDTO> buscaSalariosPorIdade();
	
	@Query("select f from Funcionario f where UPPER(substring(f.nome,1,1)) between UPPER(:letral) and UPPER(:letra2)")
	List<Funcionario> buscarPorLetraInicial(String letra1, String letra2);
	
	
	Page<Funcionario> findBySalarioBetween(Double valorMinimo, Double valorMaximo, Pageable pageable);
	Page<Funcionario> findByNomeContainingIgnoreCase(String paramNome, Pageable pageable);
}


