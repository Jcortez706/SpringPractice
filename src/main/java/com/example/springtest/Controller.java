package com.example.springtest;

import org.springframework.web.bind.annotation.*;

import static com.example.springtest.Details.Data;

@RestController

public class Controller {

    @GetMapping("/get") public String home(){
        // Get request displays data
        return "Data " + Data.toString();
    }

    @PostMapping("/post")

    String insert(@RequestBody Details ob)
    {
        // Adds an int to Data
        Data.add(ob.number);
        return "Data Inserted";
    }

    @DeleteMapping("/{id}") String delete(@PathVariable("id") int id){
        // Calls delete method on number
        Details.delete(id);
        return "Data Deleted";
    }
    @PutMapping("/put")
    String put (@RequestBody Details ob){
        Details.put(ob.number, ob.newNumber);
        return "Data Updated";
    }
}