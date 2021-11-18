package com.alvarolongueira.managerservice.controller.request.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCustomerRequest {

	private String name;

	private String surname;

	// TODO
	private Long photo;

}
