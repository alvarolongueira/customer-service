package com.alvarolongueira.customerservice.exception.customer;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.customerservice.controller.request.customer.CreateCustomerRequest;
import com.alvarolongueira.customerservice.exception.CustomerServiceException;

public class CustomerRequiredFieldsException extends CustomerServiceException {

	private static final long serialVersionUID = 1L;

	public CustomerRequiredFieldsException(CreateCustomerRequest request) {
		super("Empty required fields: " + request, HttpStatus.BAD_REQUEST);
	}

}
