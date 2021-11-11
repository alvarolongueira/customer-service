package com.github.alvarolongueira.managerservice.controller.response.customer;

import com.github.alvarolongueira.managerservice.domain.Customer;

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

	public static CustomerResponse convertToResponse(Customer customer) {
		return new CustomerResponse(customer.getName(), customer.getSurname(), customer.getPhoto());
	}
}
