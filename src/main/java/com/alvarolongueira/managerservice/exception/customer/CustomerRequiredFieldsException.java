package com.alvarolongueira.managerservice.exception.customer;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.managerservice.exception.ManagerServiceException;

public class CustomerRequiredFieldsException extends ManagerServiceException {

	private static final long serialVersionUID = 1L;

	public CustomerRequiredFieldsException(String message) {
		super(message, HttpStatus.BAD_REQUEST);
	}

}
