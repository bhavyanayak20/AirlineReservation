package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Users;

public interface UserService extends UserDetailsService {
 Users save(UserDto userdto);
 Users getUserByEmail(String email);
}
