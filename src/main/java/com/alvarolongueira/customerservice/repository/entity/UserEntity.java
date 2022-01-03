package com.alvarolongueira.customerservice.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alvarolongueira.customerservice.domain.User;
import com.alvarolongueira.customerservice.security.RoleFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;

	@Column
	private String pass;

	@Column
	private int role;

	public User toDomain() {
		return UserEntity.convertToDomain(this);
	}

	public static User convertToDomain(UserEntity entity) {
		return new User(entity.getId(), entity.getName(), entity.getPass(), RoleFactory.getRole(entity.getRole()));
	}
}
