package com.alvarolongueira.customerservice.exception.customer;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.customerservice.exception.CustomerServiceException;

public class CustomerAlreadyExistsException extends CustomerServiceException {

	private static final long serialVersionUID = 1L;

	public CustomerAlreadyExistsException(String name, String surnname) {
		super("Customer " + name + " " + surnname + " already exists", HttpStatus.NOT_MODIFIED);
	}

}
