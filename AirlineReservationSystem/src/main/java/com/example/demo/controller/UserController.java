package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

@CrossOrigin(origins ="*")
@RestController

@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	
	@PostMapping("/registration")
	public ResponseEntity<?> registerUserAccount(@RequestBody UserDto userdto){
		userService.save(userdto);
		return new ResponseEntity<UserDto>(userdto,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserDto userdto){
		Users user1 = userService.getUserByEmail(userdto.getEmail());
		System.out.println(userdto.getEmail());
		System.out.println(userdto.getEmail());
		if(userdto.getEmail().equalsIgnoreCase(userdto.getEmail())) {
			return new ResponseEntity<Users>(user1,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
	}

}