package com.example.client.service;

import com.example.client.dto.ResponseDto;
import com.example.client.entity.Users;

public interface UserService {
    Users saveUser(Users user);

    ResponseDto getUser(Long userId);


}
