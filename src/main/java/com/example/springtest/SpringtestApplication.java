package com.example.springtest;

import com.example.springtest.UserService.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringtestApplication {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringtestApplication.class, args);
	}

}
