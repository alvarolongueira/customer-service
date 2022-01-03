package com.alvarolongueira.customerservice.mock;

import com.alvarolongueira.customerservice.domain.Customer;
import com.alvarolongueira.customerservice.domain.User;
import com.alvarolongueira.customerservice.security.Role;

public class MockData {

	public static final Customer CUSTOMER_1 = new Customer(1, "Pepe", "Pepin", 1L);
	public static final Customer CUSTOMER_2 = new Customer(2, "Paco", "Paquin", 2L);
	public static final Customer CUSTOMER_3 = new Customer(3, "Manolo", "Manolin", 3L);

	public static final User ADMIN_M = new User(1, "admin_master", "pass_admin_master", Role.ADMIN);
	public static final User ADMIN_1 = new User(2, "admin_one", "pass_admin_one", Role.ADMIN);
	public static final User USER_2 = new User(3, "user_two", "pass_user_two", Role.USER);
	public static final User USER_3 = new User(4, "user_three", "pass_user_three", Role.USER);
	public static final User USER_TEST = new User(5, "user_test", "pass_user_test", Role.USER);
	
}
