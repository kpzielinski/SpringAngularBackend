package com.example.springangularbackend.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {



    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<AppUser> getUsers() {
        return (List<AppUser>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody AppUser user) {
        userRepository.save(user);
    }
}
