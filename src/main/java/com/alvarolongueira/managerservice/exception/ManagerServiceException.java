package com.alvarolongueira.managerservice.exception;

import org.springframework.http.HttpStatus;

public abstract class ManagerServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	private final HttpStatus status;

	public ManagerServiceException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
