package com.alvarolongueira.managerservice.exception.customer;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.managerservice.controller.request.customer.CreateCustomerRequest;
import com.alvarolongueira.managerservice.exception.ManagerServiceException;

public class CustomerRequiredFieldsException extends ManagerServiceException {

	private static final long serialVersionUID = 1L;

	public CustomerRequiredFieldsException(CreateCustomerRequest request) {
		super("Empty required fields: " + request, HttpStatus.BAD_REQUEST);
	}

}
