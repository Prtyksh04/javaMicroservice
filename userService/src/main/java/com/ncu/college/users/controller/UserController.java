package com.ncu.college.users.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.ncu.college.users.service.UserService;
import com.ncu.college.users.dto.UserDto;
import java.util.*;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService _UserService;

    @Autowired
    public UserController(UserService userService) {
        this._UserService = userService;
    }

    @GetMapping(path = "/allusers")
    public List<UserDto> getAllUsers() {
        return _UserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") String userId) {
        return _userService.getUserById(userId);
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UserDto userDto) {
        boolean success = _userService.addUser(userDto);
        return success ? "User added successfully!" : "Failed to add user.";
    }
}
