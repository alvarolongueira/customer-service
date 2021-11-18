package com.alvarolongueira.managerservice.controller.response.customer;

import com.alvarolongueira.managerservice.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

	@NonNull
	private String name;

	private String surname;

	// TODO
	private Long photo;

	public static CustomerResponse convertToResponse(Customer customer) {
		return new CustomerResponse(customer.getName(), customer.getSurname(), customer.getPhoto());
	}
}
