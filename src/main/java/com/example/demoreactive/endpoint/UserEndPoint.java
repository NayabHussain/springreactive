package com.example.demoreactive.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoreactive.domain.User;
import com.example.demoreactive.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Component
@RequestMapping("user")
@RestController
public class UserEndPoint {

	@Autowired
	UserService userService;

	@GetMapping("/all")
	Flux<User> getAllUsers() {
		Flux<User> users = userService.findAllusers();

		return users;
	}

	@GetMapping("/getbyname/{name}")
	Mono<User> getUserByName(@PathVariable("name") String name) {

		Mono<User> user = userService.FindUserByName(name);

		return user;

	}

//	@Bean
//    public RouterFunction blogroute(){
//        return RouterFunctions.nest(RequestPredicates.path("/user"),
//                RouterFunctions.route(RequestPredicates.GET("/all"),
//                        req-> ServerResponse.ok().body(userService.findAllusers(),User.class))
//                
//        );
//    }

}
