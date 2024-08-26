package com.example.springtest.UserService;

import com.example.springtest.LocationCodeService.LocationCode;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {
    @Id
    private String name;

    private LocationCode locationCode;

    public User(String name, LocationCode locationCode){
        super();
        this.name = name;
        this.locationCode = locationCode;
    }
}
