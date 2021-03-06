package com.alvarolongueira.customerservice.controller.response.customer;

import com.alvarolongueira.customerservice.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

	private String name;

	private String surname;

	// TODO
	private Long photo;

	public static CustomerResponse convertToResponse(Customer customer) {
		return new CustomerResponse(customer.getName(), customer.getSurname(), customer.getPhoto());
	}
}
