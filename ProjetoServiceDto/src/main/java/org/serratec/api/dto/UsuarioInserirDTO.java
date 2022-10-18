package org.serratec.api.dto;

import java.util.Set;

import org.serratec.api.domain.Perfil;

public class UsuarioInserirDTO {

	private String nome;
	private String email;
	private String senha;
	private String ConfirmaSenha;
	private Set<Perfil> perfis;
	

	public UsuarioInserirDTO() {
		super();
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return ConfirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		ConfirmaSenha = confirmaSenha;
	}

}
