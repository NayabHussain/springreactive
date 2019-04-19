package com.example.demoreactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demoreactive.domain.User;

import reactor.core.publisher.Mono;

@Repository
public interface UserReactiveRepository extends ReactiveCrudRepository<User, String> {
	
	 Mono<User> findByUserName(String userName);
	
}
