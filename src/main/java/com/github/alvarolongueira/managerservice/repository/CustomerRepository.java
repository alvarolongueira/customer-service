package com.github.alvarolongueira.managerservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.alvarolongueira.managerservice.repository.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long>{

}
