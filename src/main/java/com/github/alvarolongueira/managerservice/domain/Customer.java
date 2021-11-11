package com.github.alvarolongueira.managerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

	private long id;

	private String name;

	private String surname;

	private long creationUser;

	private long modificationUser;

	// TODO
	private String photo;

}
