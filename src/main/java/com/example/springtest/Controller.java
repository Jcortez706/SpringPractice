package com.example.springtest;

import com.example.springtest.LocationCodeService.LocationCode;
import com.example.springtest.UserService.User;
import com.example.springtest.UserService.UserService;
import com.example.springtest.WeatherService.Weather;
import com.example.springtest.WeatherService.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:8080")
public class Controller {
    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    private UserService userService;
    @GetMapping("/get")
    String getWeather(){
        return weatherRepository.findAllWeather().toString();
    }
    @GetMapping("/get/{location}")
    String getLocationCity(@PathVariable("location") String location){
        String[] locationArray = location.split("&");
        return Arrays.toString(locationArray);
    }

    @PostMapping("/post")
    HttpStatus createWeather(@RequestBody Weather weatherInput){
        weatherRepository.save(weatherInput);
        return HttpStatus.CREATED;
    }

    @PostMapping("/user")
    HttpStatus createUser(){
        LocationCode locationCode = new LocationCode(); // Create or fetch your LocationCode object
        userService.createUser("Jacob", locationCode);
        return HttpStatus.CREATED;
    }

}