package com.example.springtest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(DataRepository repository){
        return args ->{
            System.out.println("Preloading " + repository.save(new Data(1,12)));
            repository.findAll().forEach(data -> System.out.println("Loaded " + data));
        };
    }
}
