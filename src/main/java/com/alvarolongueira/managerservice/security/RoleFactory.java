package com.alvarolongueira.managerservice.security;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

public class RoleFactory {

	private static final BiMap<String, Integer> MAP = ImmutableBiMap.<String, Integer>builder()
			.put(Role.ADMIN, 1)
			.put(Role.USER, 2)
			.build();

	public static String getRole(int idRole) {
		return MAP.inverse().get(idRole);
	}
}
