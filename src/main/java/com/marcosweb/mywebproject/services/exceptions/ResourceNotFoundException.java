package com.marcosweb.mywebproject.services.exceptions;

//para tratar exceções específicas do spring data
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		//se não adicionar mensagem, o Json volta com o campo message = "null"
		super("Resource not found. Id " + id);
	}
}