package com.example.springtest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(DataRepository repository){
        return args ->{
            repository.findAll().forEach(data -> System.out.println("Loaded " + data));
        };
    }
}
