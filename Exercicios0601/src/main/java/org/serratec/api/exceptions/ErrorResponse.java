package org.serratec.api.exceptions;

import java.time.LocalDate;
import java.util.List;

public class ErrorResponse {
	private Integer status;
	private String titulo;
	private LocalDate dataHora;
	private List<String> errors;

	public ErrorResponse(Integer status, String titulo, LocalDate dataHora, List<String> errors) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.dataHora = dataHora;
		this.errors = errors;
	}

	public Integer getStatus() {
		return status;
	}

	public String getTitulo() {
		return titulo;
	}

	public LocalDate getDataHora() {
		return dataHora;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	


}
