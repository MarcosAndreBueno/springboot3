package com.marcosweb.mywebproject.services.exceptions;

//para tratar exceções específicas do JPA Hibernate
public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatabaseException(String msg) {
		super(msg);
	}
}