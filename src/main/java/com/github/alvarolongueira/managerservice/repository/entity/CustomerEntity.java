package com.github.alvarolongueira.managerservice.repository.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class CustomerEntity {

	private long id;

	private String name;

	private String surname;

	private long creationUser;

	private long modificationUser;

	// TODO
	private String photo;

}
