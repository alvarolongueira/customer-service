package com.alvarolongueira.managerservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alvarolongueira.managerservice.controller.request.customer.CreateCustomerRequest;
import com.alvarolongueira.managerservice.controller.request.customer.UpdateCustomerRequest;
import com.alvarolongueira.managerservice.domain.Customer;
import com.alvarolongueira.managerservice.repository.CustomerRepository;
import com.alvarolongueira.managerservice.repository.entity.CustomerEntity;

@Service
public class CustomerService {

	private CustomerRepository repository;

	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		this.repository.findAll().forEach(value -> customers.add(CustomerEntity.convertToDomain(value)));
		return customers;
	}

	public Customer getCustomerById(long customerId) {
		return repository.findById(customerId).map(CustomerEntity::convertToDomain)
				// TODO generar excepcion
				.orElse(null);
		// .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
	}

	public Customer createCustomer(CreateCustomerRequest request) {
		// TODO
		return null;
	}

	public Void deleteCustomer(long customerId) {
		this.repository.deleteById(customerId);
		return null;
	}

	public Customer updateCustomer(long customerId, UpdateCustomerRequest request) {
		// TODO
		return null;
	}

}
