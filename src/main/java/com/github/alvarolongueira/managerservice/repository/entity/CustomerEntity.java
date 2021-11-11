package com.github.alvarolongueira.managerservice.repository.entity;

import javax.persistence.Entity;

import com.github.alvarolongueira.managerservice.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class CustomerEntity {

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

	public static CustomerEntity convertToEntity(Customer customer) {
		return new CustomerEntity(customer.getId(), customer.getName(), customer.getSurname(), customer.getCreationUser(), customer.getModificationUser(),
				customer.getPhoto());
	}
}
