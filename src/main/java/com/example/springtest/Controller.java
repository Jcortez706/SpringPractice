package com.example.springtest;

import org.springframework.web.bind.annotation.*;

import static com.example.springtest.Details.Data;

@RestController

public class Controller {

    @GetMapping("/get")
    String getData(){
        // Get request displays data
        return "Data " + Data.toString();
    }

    @PostMapping("/post")

    String insertData(@RequestBody Details ob)
    {
        // Adds an int to Data
        Data.add(ob.number);
        return "Data Inserted";
    }

    @DeleteMapping("/{id}")
    String deleteData(@PathVariable("id") int id){
        // Calls delete method on id
        Details.delete(id);
        return "Data Deleted";
    }
    @PutMapping("/put")
    String putData(@RequestBody Details ob){
        // Updates specific number with new number
        Details.put(ob.number, ob.newNumber);
        return "Data Updated";
    }
}