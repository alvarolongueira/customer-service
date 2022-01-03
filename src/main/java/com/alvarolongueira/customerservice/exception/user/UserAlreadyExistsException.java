package com.alvarolongueira.customerservice.exception.user;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.customerservice.exception.CustomerServiceException;

public class UserAlreadyExistsException extends CustomerServiceException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String name) {
		super("User " + name + " already exists", HttpStatus.NOT_MODIFIED);
	}

}
