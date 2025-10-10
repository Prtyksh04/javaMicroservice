package com.ncu.college.users.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.ncu.college.users.service.UserService;
import com.ncu.college.users.dto.UserDto;
import java.util.*;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/allusers")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UserDto userDto) {
        boolean success = userService.addUser(userDto);
        return success ? "User added successfully!" : "Failed to add user.";
    }

    
}
