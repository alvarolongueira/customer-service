package com.alvarolongueira.managerservice.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.alvarolongueira.managerservice.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private Long photo;

	@Column
	@CreatedBy
	private String creationUser;

	@Column
	@LastModifiedBy
	private String modificationUser;

	public Customer toDomain() {
		return CustomerEntity.convertToDomain(this);
	}

	public static Customer convertToDomain(CustomerEntity entity) {
		return new Customer(entity.getId(), entity.getName(), entity.getSurname(), entity.getPhoto());
	}

}
