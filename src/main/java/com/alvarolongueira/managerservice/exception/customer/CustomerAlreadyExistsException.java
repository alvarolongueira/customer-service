package com.alvarolongueira.managerservice.exception.customer;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.managerservice.exception.ManagerServiceException;

public class CustomerAlreadyExistsException extends ManagerServiceException {

	private static final long serialVersionUID = 1L;

	public CustomerAlreadyExistsException(String message) {
		super(message, HttpStatus.NOT_MODIFIED);
	}

}
