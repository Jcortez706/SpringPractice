package com.example.springtest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController

public class Controller {
    private final List<Integer> numbers = new ArrayList<>();
    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @GetMapping("/get")
    String getData(){
        // Get request displays data
        return "Data " + numbers;
    }

    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @PostMapping("/post")
    String insertData(@RequestBody Map<String, Integer> request)
    {
        // Adds an int to Data
        Integer number = request.get("number");
        numbers.add(number);
        return "Data Inserted";
    }

    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @DeleteMapping("/{id}")
    String deleteData(@PathVariable("id") int id){
        // Calls delete method on id
        numbers.remove((Integer) id);
        return "Data Deleted";
    }
    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @PutMapping("/put")
    String putData(@RequestBody Map<String, Integer> update){
        // Updates specific number with new number
        Integer newNumber = update.get("new");
        Integer numberToReplace = update.get("number");
        int temp = numbers.indexOf(numberToReplace);
        if (temp != -1) {
            numbers.set(temp, newNumber);
        }
        return "Data Updated";
    }
}