package com.example.thymeleaf.service;

import com.example.thymeleaf.dto.UserDto;
import com.example.thymeleaf.entity.Users;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    Users findUserByEmail(String email);

    List<Users> findAllUsers();
}
