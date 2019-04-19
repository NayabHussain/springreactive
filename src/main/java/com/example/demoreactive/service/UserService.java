package com.example.demoreactive.service;

import com.example.demoreactive.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

	Flux<User> findAllusers();
	
	Mono<User> FindUserByName(String name);
}
