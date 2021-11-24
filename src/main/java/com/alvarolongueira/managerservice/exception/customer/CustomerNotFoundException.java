package com.alvarolongueira.managerservice.exception.customer;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.managerservice.exception.ManagerServiceException;

public class CustomerNotFoundException extends ManagerServiceException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(long customerId) {
		super("Customer with id " + customerId + " not found", HttpStatus.NOT_FOUND);
	}

}
