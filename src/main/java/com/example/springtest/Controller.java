package com.example.springtest;

import com.example.springtest.LocationCodeService.LocationCode;
import com.example.springtest.LocationCodeService.LocationCodeRepository;
import com.example.springtest.UserService.User;
import com.example.springtest.UserService.UserService;
import com.example.springtest.WeatherService.Weather;
import com.example.springtest.WeatherService.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;


@RestController
@CrossOrigin(origins = {"http://127.0.0.1:8080", "http://localhost:8080"})
public class Controller {
    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    LocationCodeRepository locationCodeRepository;
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
    @GetMapping("/matching")
    String getMatchingCities(){
        return weatherRepository.findLocationCodesByCity().toString();
    }

    @PostMapping("/weather")
    public HttpStatus createWeather(@RequestBody Weather weatherInput){
        weatherRepository.save(weatherInput);
        return HttpStatus.CREATED;
    }

    @PostMapping("/location")
    HttpStatus createLocation(@RequestBody LocationCode locationCodeInput){
        locationCodeRepository.save(locationCodeInput);
        return HttpStatus.CREATED;
    }

    @PostMapping("/user")
    HttpStatus createUser(){
        LocationCode locationCode = new LocationCode(); // Create or fetch your LocationCode object
        userService.createUser("Jacob", locationCode);
        return HttpStatus.CREATED;
    }

    @GetMapping("/{date}&{city}")
    String getDetailsByDateAndCity(@PathVariable("date")String date, @PathVariable("city") String city){
        List<String> weatherDetails = new ArrayList<>();
        weatherRepository.findWeatherByDateAndCity(date, city).forEach(weather -> {
            weatherDetails.add(weather.getDescription());
        });

        return weatherDetails.toString();
    }

}