package com.alvarolongueira.customerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

	private long id;

	private String name;

	private String surname;

	// TODO
	private Long photo;

}
