package com.alvarolongueira.customerservice.exception.user;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.customerservice.exception.CustomerServiceException;

public class UserNotFoundException extends CustomerServiceException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(long userId) {
		super("User with id " + userId + " not found", HttpStatus.NOT_FOUND);
	}

	public UserNotFoundException(String message) {
		super(message, HttpStatus.NOT_FOUND);
	}
}
