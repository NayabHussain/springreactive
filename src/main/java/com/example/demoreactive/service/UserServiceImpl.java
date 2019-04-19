package com.example.demoreactive.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoreactive.domain.User;
import com.example.demoreactive.repository.UserReactiveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserReactiveRepository userReactiveRepository;

	@Override
	public Flux<User> findAllusers() {
		return userReactiveRepository.findAll();
	}

	@Override
	public Mono<User> FindUserByName(String name) {
		return userReactiveRepository.findByUserName(name);
	}

	@Override
	public Mono<User> createUser(User user) {
		return userReactiveRepository.save(user);
	}

	@Override
	public Mono<User> updateUser(User user) {
		Objects.requireNonNull(user.getId(), "Id cannot be null");
		return userReactiveRepository.save(user);
	}

	@Override
	public Mono<Void> deleteUserById(String id) {

		System.out.println("in delete "+id);
		return userReactiveRepository.deleteById(id);
		
	}

}
