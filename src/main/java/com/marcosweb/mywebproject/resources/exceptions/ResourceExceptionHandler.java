package com.marcosweb.mywebproject.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.marcosweb.mywebproject.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

//esta classe irá tratar nossas exceções personalizadas. Ela contrói o corpo da mensagem de erro, estabelece o código correto para exceção, etc.
@ControllerAdvice
public class ResourceExceptionHandler {

	//@ExceptionHandler permite que esta classe execute após a classe ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}