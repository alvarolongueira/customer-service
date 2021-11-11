package com.github.alvarolongueira.managerservice.domain;

import com.github.alvarolongueira.managerservice.repository.entity.CustomerEntity;

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

	public static Customer convertToDomain(CustomerEntity entity) {
		return new Customer(entity.getId(), entity.getName(), entity.getSurname(), entity.getCreationUser(), entity.getModificationUser(), entity.getPhoto());
	}

}
