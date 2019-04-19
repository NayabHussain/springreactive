package com.example.demoreactive.service;

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

}
