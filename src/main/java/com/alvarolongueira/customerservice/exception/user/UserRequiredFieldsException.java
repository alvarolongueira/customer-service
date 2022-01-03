package com.alvarolongueira.customerservice.exception.user;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.customerservice.controller.request.user.CreateUserRequest;
import com.alvarolongueira.customerservice.exception.CustomerServiceException;

public class UserRequiredFieldsException extends CustomerServiceException {

	private static final long serialVersionUID = 1L;

	public UserRequiredFieldsException(CreateUserRequest request) {
		super("Empty required fields: " + request, HttpStatus.BAD_REQUEST);
	}

}
