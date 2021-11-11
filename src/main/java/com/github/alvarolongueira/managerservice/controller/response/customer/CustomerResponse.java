package com.github.alvarolongueira.managerservice.controller.response.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class CustomerResponse {

	@NonNull
	private String name;

	private String surname;

	// TODO
	private String photo;

}
