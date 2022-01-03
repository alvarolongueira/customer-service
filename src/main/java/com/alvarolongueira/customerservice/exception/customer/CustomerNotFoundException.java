package com.alvarolongueira.customerservice.exception.customer;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.customerservice.exception.CustomerServiceException;

public class CustomerNotFoundException extends CustomerServiceException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(long customerId) {
		super("Customer with id " + customerId + " not found", HttpStatus.NOT_FOUND);
	}

}
