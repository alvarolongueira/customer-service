package com.alvarolongueira.managerservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.alvarolongueira.managerservice.repository.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long>{

}
