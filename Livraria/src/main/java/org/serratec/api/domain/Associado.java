package org.serratec.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "associado")
public class Associado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_associado")
	private Long id;

	@NotBlank(message = "Preencha o nome")
	@Size(max = 50)
	@Column(nullable = false, length = 50)
	private String nome;

	@NotBlank(message = "Preencha o telefone")
	@Size(max = 15)
	@Column(nullable = false, length = 15)
	private String telefone;

	@NotBlank(message = "Preencha o cpf")
	// @CPF(message="CPF Inválido")
	@Size(max = 11)
	@Column(nullable = false, length = 11)
	private String cpf;

	@NotBlank(message = "Preencha o logradouro")
	@Size(max = 80)
	@Column(nullable = false, length = 80)
	private String logradouro;

	@NotBlank(message = "Preencha o numero")
	@Size(max = 10)
	@Column(nullable = false, length = 10)
	private String numero;

	@NotBlank(message = "Preencha o complemento")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	private String complemento;

	@NotBlank(message = "Preencha o bairro")
	@Size(max = 50)
	@Column(nullable = false, length = 50)
	private String bairro;

	@NotBlank(message = "Preencha o cidade")
	@Size(max = 50)
	@Column(nullable = false, length = 50)
	private String cidade;

	@NotBlank(message = "Preencha o estado")
	@Size(max = 2)
	@Column(nullable = false, length = 2)
	private String estado;

	public Associado() {
		super();
	}

	public Associado(Long id, String nome, String telefone, String cpf, String logradouro, String numero,
			String complemento, String bairro, String cidade, String estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
