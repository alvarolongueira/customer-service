package com.alvarolongueira.managerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

	private long id;

	private String name;

	private String pass;

	private String role;

}
