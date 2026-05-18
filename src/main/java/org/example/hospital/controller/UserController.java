package org.example.hospital.controller;

import org.example.hospital.model.User;
import org.example.hospital.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
    this.userService = userService;
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(
                user.getUsername(),
                user.getPassword()
        );
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}


