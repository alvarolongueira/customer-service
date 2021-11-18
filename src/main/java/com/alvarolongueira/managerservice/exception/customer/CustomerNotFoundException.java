package com.alvarolongueira.managerservice.exception.customer;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.managerservice.exception.ManagerServiceException;

public class CustomerNotFoundException extends ManagerServiceException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String message) {
		super(message, HttpStatus.NOT_FOUND);
	}

}
