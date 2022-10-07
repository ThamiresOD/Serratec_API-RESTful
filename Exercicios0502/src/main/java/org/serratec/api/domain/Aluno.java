package org.serratec.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="matricula_aluno")
	private Long matricula;
	
	@Column(name="nome", nullable = false, length = 60)
	private String nome;
	
	@Column(name="telefone", length = 30)
	private String telefone;


	public Aluno(Long matricula, String nome, String telefone) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Aluno() {
		super();
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", telefone=" + telefone + "]";
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
