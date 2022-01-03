package com.alvarolongueira.customerservice.controller.request.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCustomerRequest {

	private String name;

	private String surname;

	// TODO
	private Long photo;

}
