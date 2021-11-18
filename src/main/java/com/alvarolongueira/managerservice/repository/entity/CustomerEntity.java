package com.alvarolongueira.managerservice.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alvarolongueira.managerservice.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private Long photo;

	@Column
	private String creationUser;

	@Column
	private String modificationUser;

	public Customer toDomain() {
		return CustomerEntity.convertToDomain(this);
	}

	public static Customer convertToDomain(CustomerEntity entity) {
		return new Customer(entity.getId(), entity.getName(), entity.getSurname(), entity.getPhoto(), entity.getCreationUser(), entity.getModificationUser());
	}

	public static CustomerEntity convertToEntity(Customer customer) {
		return new CustomerEntity(customer.getId(), customer.getName(), customer.getSurname(), customer.getPhoto(), customer.getCreationUser(),
				customer.getModificationUser());
	}
}
