package com.alvarolongueira.customerservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvarolongueira.customerservice.controller.request.customer.CreateCustomerRequest;
import com.alvarolongueira.customerservice.controller.request.customer.UpdateCustomerRequest;
import com.alvarolongueira.customerservice.domain.Customer;
import com.alvarolongueira.customerservice.exception.customer.CustomerAlreadyExistsException;
import com.alvarolongueira.customerservice.exception.customer.CustomerNotFoundException;
import com.alvarolongueira.customerservice.exception.customer.CustomerRequiredFieldsException;
import com.alvarolongueira.customerservice.repository.CustomerRepository;
import com.alvarolongueira.customerservice.repository.entity.CustomerEntity;

@Service
public class CustomerService {

	private final CustomerRepository repository;

	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		this.repository.findAll().forEach(value -> customers.add(CustomerEntity.convertToDomain(value)));
		return customers;
	}

	public Customer getCustomerById(long customerId) {
		return this.repository.findById(customerId).map(CustomerEntity::convertToDomain).orElseThrow(() -> new CustomerNotFoundException(customerId));
	}

	@Transactional
	public Customer createCustomer(CreateCustomerRequest request) {

		if (request.getName().isEmpty() || request.getSurname().isEmpty() || request.getPhoto() <= 0L) {
			throw new CustomerRequiredFieldsException(request);
		}

		Optional<CustomerEntity> oldEntity = this.repository.findByNameAndSurname(request.getName(), request.getSurname());
		if (oldEntity.isPresent()) {
			throw new CustomerAlreadyExistsException(request.getName(), request.getSurname());
		}

		CustomerEntity newEntity = new CustomerEntity();
		newEntity.setName(request.getName());
		newEntity.setSurname(request.getSurname());
		newEntity.setPhoto(request.getPhoto());

		CustomerEntity entity = this.repository.save(newEntity);

		return entity.toDomain();
	}

	@Transactional
	public Void deleteCustomer(long customerId) {
		Optional<CustomerEntity> oldEntity = this.repository.findById(customerId);
		if (!oldEntity.isPresent()) {
			throw new CustomerNotFoundException(customerId);
		}

		this.repository.deleteById(customerId);
		return null;
	}

	@Transactional
	public Customer updateCustomer(long customerId, UpdateCustomerRequest request) {
		if (request.getName().isEmpty() || request.getSurname().isEmpty() || request.getPhoto() <= 0L) {
			throw new CustomerAlreadyExistsException(request.getName(), request.getSurname());
		}

		Optional<CustomerEntity> oldEntity = this.repository.findById(customerId);
		if (!oldEntity.isPresent()) {
			throw new CustomerNotFoundException(customerId);
		}

		Optional<CustomerEntity> oldEntitySameFields = this.repository.findByNameAndSurname(request.getName(), request.getSurname());
		if (oldEntitySameFields.isPresent() && (oldEntitySameFields.get().getId() != customerId)) {
			throw new CustomerAlreadyExistsException(request.getName(), request.getSurname());
		}

		CustomerEntity newEntity = oldEntity.get();
		newEntity.setName(request.getName());
		newEntity.setSurname(request.getSurname());
		newEntity.setPhoto(request.getPhoto());
		CustomerEntity entity = this.repository.save(newEntity);

		return entity.toDomain();
	}

}
