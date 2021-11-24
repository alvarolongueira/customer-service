package com.alvarolongueira.managerservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alvarolongueira.managerservice.controller.request.user.CreateUserRequest;
import com.alvarolongueira.managerservice.controller.request.user.UpdateUserRequest;
import com.alvarolongueira.managerservice.domain.User;
import com.alvarolongueira.managerservice.exception.user.UserAlreadyExistsException;
import com.alvarolongueira.managerservice.exception.user.UserNotFoundException;
import com.alvarolongueira.managerservice.exception.user.UserRequiredFieldsException;
import com.alvarolongueira.managerservice.repository.UserRepository;
import com.alvarolongueira.managerservice.repository.entity.UserEntity;
import com.alvarolongueira.managerservice.security.RoleFactory;

@Service
public class UserService {

	private UserRepository repository;

	private UserService(UserRepository userRepository) {
		this.repository = userRepository;
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		this.repository.findAll().forEach(value -> users.add(UserEntity.convertToDomain(value)));
		return users;
	}

	public User getUserById(long userId) {
		return repository.findById(userId).map(UserEntity::convertToDomain).orElseThrow(() -> new UserNotFoundException(userId));
	}

	public User createUser(CreateUserRequest request) {
		if (request.getName().isEmpty() || request.getPass().isEmpty() || request.getRole().isEmpty()) {
			throw new UserRequiredFieldsException(request);
		}

		Optional<UserEntity> oldEntity = repository.findByNameAndPass(request.getName(), request.getPass());
		if (oldEntity.isPresent()) {
			throw new UserAlreadyExistsException(request.getName());
		}

		UserEntity newEntity = new UserEntity();
		newEntity.setName(request.getName());
		newEntity.setPass(request.getPass());
		newEntity.setRole(RoleFactory.getRole(request.getRole()));

		UserEntity entity = repository.save(newEntity);
		return entity.toDomain();
	}

	public User updateUser(long userId, UpdateUserRequest request) {
		Optional<UserEntity> oldEntity = repository.findById(userId);
		if (!oldEntity.isPresent()) {
			throw new UserNotFoundException(userId);
		}

		Optional<UserEntity> oldEntitySameFields = repository.findByNameAndPass(request.getName(), request.getPass());
		if (oldEntitySameFields.isPresent() && (oldEntitySameFields.get().getId() != userId)) {
			throw new UserAlreadyExistsException(request.getName());
		}

		UserEntity newEntity = oldEntity.get();
		newEntity.setName(request.getName());
		newEntity.setPass(request.getPass());
		newEntity.setRole(RoleFactory.getRole(request.getRole()));

		UserEntity entity = repository.save(newEntity);
		return entity.toDomain();
	}

	public Void deleteUser(long userId) {
		Optional<UserEntity> oldEntity = repository.findById(userId);
		if (!oldEntity.isPresent()) {
			throw new UserNotFoundException(userId);
		}

		this.repository.deleteById(userId);
		return null;
	}

}
