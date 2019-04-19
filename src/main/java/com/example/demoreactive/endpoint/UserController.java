package com.example.demoreactive.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoreactive.domain.User;
import com.example.demoreactive.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Component
@RequestMapping(path = "user")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/all")
	Flux<User> getAllUsers() {
		return userService.findAllusers();
	}

	@GetMapping(path = "/getbyname/{name}")
	Mono<User> getUserByName(@PathVariable("name") String name) {
		return userService.FindUserByName(name);

	}

	@PostMapping(path = "/create")
	Mono<User> createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping(path = "/update")
	Mono<User> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping(path = "/delete/{id}")
	Mono<Void> deleteUserById(@PathVariable("id") String id) {
		return userService.deleteUserById(id);

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
