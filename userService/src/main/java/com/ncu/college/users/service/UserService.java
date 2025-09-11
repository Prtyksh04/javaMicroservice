package com.ncu.college.users.service;

import com.ncu.college.users.dto.UserDto;
import com.ncu.college.users.irepository.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.ncu.college.users.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service(value = "UserService")
public class UserService {
    private final IUserRepository _userRepository;
    private final ModelMapper _modelMapper;

    @Autowired
    public UserService(IUserRepository userRepository, ModelMapper modelMapper) {
        this._userRepository = userRepository;
        this._modelMapper = modelMapper;
    }

    public List<UserDto> getAllUsers() {
        List<User> users = _userRepository.GetAllUsers();
        List<UserDto> userDtos = new ArrayList<>();

        for (User u : users) {
            UserDto dto = _modelMapper.map(u, UserDto.class);
            userDtos.add(dto);
        }

        return userDtos;
    }

    public UserDto getUserById(String userId) {
        User user = _userRepository.GetUserById(userId);
        if (user == null) {
            return null; // or throw exception if you prefer
        }
        return _modelMapper.map(user, UserDto.class);
    }

    public boolean addUser(UserDto userDto) {
        try {
            User user = _modelMapper.map(userDto, User.class);
            int rows = _userRepository.AddUser(user);
            return rows > 0;
        } catch (Exception e) {
            System.out.println("Error in service addUser: " + e.getMessage());
            return false;
        }
    }
}
