package com.example.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class Controller {
    private final List<Integer> numbers = new ArrayList<>();
    @Autowired
    DataRepository dataRepository;
    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @GetMapping("/get")
    String getData(){
        // Get request displays data
        return "Data " + dataRepository.findAllDatacol();
    }

    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @PostMapping("/post")
    String insertData(@RequestBody Map<String, Integer> request)
    {
        // Adds an int to Data
        Data data = new Data(request.get("number"));
        dataRepository.save(data);
        return "Data Inserted";
    }

    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @DeleteMapping("/{id}")
    String deleteData(@PathVariable("id") int id){
        // Calls delete method on id
        dataRepository.deleteData(id);
        return "Data Deleted";
    }
    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @PutMapping("/put")
    String putData(@RequestBody Map<String, Integer> update){
        // Updates specific number with new number
        Integer newNumber = update.get("new");
        Integer numberToReplace = update.get("number");
        dataRepository.updataDatacolByID(newNumber, numberToReplace);
        return "Data Updated";
    }
}