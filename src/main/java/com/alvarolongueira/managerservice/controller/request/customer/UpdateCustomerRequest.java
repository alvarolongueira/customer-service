package com.alvarolongueira.managerservice.controller.request.customer;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

	private String name;

	private String surname;

	private long modificationUser;

	// TODO
	private String photo;

}
