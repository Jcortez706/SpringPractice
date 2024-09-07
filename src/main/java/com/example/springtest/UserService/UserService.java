package com.example.springtest.UserService;

import com.example.springtest.LocationCodeService.LocationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String name, LocationCode locationCode) {
        User user = new User(name, locationCode);
        userRepository.save(user);
    }
}