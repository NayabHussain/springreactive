package com.example.demoreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class DemoreactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoreactiveApplication.class, args);
	}

	
}
