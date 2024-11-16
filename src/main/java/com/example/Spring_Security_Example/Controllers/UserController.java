package com.example.Spring_Security_Example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring_Security_Example.Entities.Users;
import com.example.Spring_Security_Example.Services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public Users registerUser(@RequestBody Users user) {
		return userService.registerUser(user);
	}
}
