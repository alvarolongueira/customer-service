package com.alvarolongueira.managerservice.exception.user;

import org.springframework.http.HttpStatus;

import com.alvarolongueira.managerservice.exception.ManagerServiceException;

public class UserAlreadyExistsException extends ManagerServiceException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String name) {
		super("User " + name + " already exists", HttpStatus.NOT_MODIFIED);
	}

}
