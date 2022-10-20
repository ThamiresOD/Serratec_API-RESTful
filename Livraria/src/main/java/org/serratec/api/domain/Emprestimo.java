package org.serratec.api.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_emprestimo")
	private Long id;

	@NotBlank(message = "Preencha a data de emprestimo")
	@Column(name = "dataEmprestimo")
	// @Past(message = "Não pode nascer no futuro")
	private LocalDate dataEmprestimo;

	public Emprestimo() {
		super();
	}

	public Emprestimo(Long id, LocalDate dataEmprestimo) {
		super();
		this.id = id;
		this.dataEmprestimo = dataEmprestimo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

}
