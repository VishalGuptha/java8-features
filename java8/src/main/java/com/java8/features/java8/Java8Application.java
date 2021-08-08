package com.java8.features.java8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Java8Application {

	public static void main(String[] args) {
		SpringApplication.run(Java8Application.class, args);
		
		UserService userService = new UserService();
		
		userService.userServiceWithFilter();
		
		userService.userServiceWithMap();
		
		userService.userServiceWithMapToInt();
		
		userService.userServiceWithFlatMapAndOptional();
	}

}
