package com.github.alvarolongueira.managerservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.alvarolongueira.managerservice.controller.request.customer.CreateCustomerRequest;
import com.github.alvarolongueira.managerservice.controller.request.customer.UpdateCustomerRequest;
import com.github.alvarolongueira.managerservice.controller.response.customer.CustomerResponse;

@Service
public class CustomerService {

	public CustomerService() {

	}

	public List<CustomerResponse> getAllCustomers() {
		// TODO
		return null;
	}

	public CustomerResponse getCustomerById(long customerId) {
		// TODO
		return null;
	}

	public CustomerResponse createCustomer(CreateCustomerRequest request) {
		// TODO
		return null;
	}

	public Void deleteCustomer(long customerId) {
		// TODO
		return null;
	}

	public CustomerResponse updateCustomer(long customerId, UpdateCustomerRequest request) {
		// TODO
		return null;
	}

}
