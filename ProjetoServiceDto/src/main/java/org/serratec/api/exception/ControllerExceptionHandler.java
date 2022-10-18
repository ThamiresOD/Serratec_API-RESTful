package org.serratec.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmailException.class)
	public ResponseEntity<Object> emailExceptionHandler(EmailException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}

	@ExceptionHandler(SenhaException.class)
	public ResponseEntity<Object> senhaExceptionHandler(SenhaException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}
}
