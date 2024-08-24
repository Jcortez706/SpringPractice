package com.example.springtest;

import com.example.springtest.WeatherService.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class Controller {
    @Autowired
    WeatherRepository weatherRepository;
    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @GetMapping("/get")
    String getWeather(){
        return weatherRepository.findAllWeather().toString();
    }
    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @GetMapping("/get/{location}")
    String getLocationCity(@PathVariable("location") String location){
        String[] locationArray = location.split("&");
        return Arrays.toString(locationArray);
    }

}