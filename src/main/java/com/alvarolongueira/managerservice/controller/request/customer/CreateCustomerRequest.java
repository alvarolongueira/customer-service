package com.alvarolongueira.managerservice.controller.request.customer;

import lombok.Data;

@Data
public class CreateCustomerRequest {

	private String name;

	private String surname;

	private long creationUser;

	// TODO
	private String photo;

}
