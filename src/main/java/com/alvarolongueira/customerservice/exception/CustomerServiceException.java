package com.alvarolongueira.customerservice.exception;

import org.springframework.http.HttpStatus;

public abstract class CustomerServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final HttpStatus status;

	public CustomerServiceException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	HttpStatus getStatus() {
		return this.status;
	}

}
