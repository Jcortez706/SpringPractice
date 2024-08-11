package com.example.springtest;

import com.example.springtest.LocationService.Location;
import com.example.springtest.LocationService.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
    private final List<Integer> numbers = new ArrayList<>();
    @Autowired
    LocationRepository locationRepository;
    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @GetMapping("/get")
    String getData(){
        // Get request displays data
        return "Data " + locationRepository.findAllLocations();
    }
    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @GetMapping("/get/{city}")
    String getLocationCity(@PathVariable("city") String city){
        // Get request displays data
        List<Location> location = locationRepository.findLocationByCity(city);
        return "Data " + location.toString();
    }

//    @CrossOrigin(origins = "http://127.0.0.1:8080")
//    @PostMapping("/post")
//    String insertData(@RequestBody Map<String, Integer> request)
//    {
//        // Adds an int to Data
//        Data data = new Data(request.get("number"));
//        dataRepository.save(data);
//        return "Data Inserted";
//    }
//
//    @CrossOrigin(origins = "http://127.0.0.1:8080")
//    @DeleteMapping("/{id}")
//    String deleteData(@PathVariable("id") int id){
//        // Calls delete method on id
//        dataRepository.deleteData(id);
//        return "Data Deleted";
//    }
//    @CrossOrigin(origins = "http://127.0.0.1:8080")
//    @PutMapping("/put")
//    String putData(@RequestBody Map<String, Integer> update){
//        // Updates specific number with new number
//        Integer newNumber = update.get("new");
//        Integer numberToReplace = update.get("number");
//        dataRepository.updataDatacolByID(newNumber, numberToReplace);
//        return "Data Updated";
//    }
}