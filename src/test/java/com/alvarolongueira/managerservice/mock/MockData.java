package com.alvarolongueira.managerservice.mock;

import com.alvarolongueira.managerservice.domain.Customer;
import com.alvarolongueira.managerservice.domain.User;
import com.alvarolongueira.managerservice.security.Role;

public class MockData {

	public static final Customer CUSTOMER_1 = new Customer(1, "Pepe", "Pepin", 1L);
	public static final Customer CUSTOMER_2 = new Customer(1, "Paco", "Paquin", 2L);
	public static final Customer CUSTOMER_3 = new Customer(1, "Manolo", "Manolin", 3L);

	public static final User USER_1 = new User(1, "admin_master", "pass_admin_master", Role.ADMIN);

}
