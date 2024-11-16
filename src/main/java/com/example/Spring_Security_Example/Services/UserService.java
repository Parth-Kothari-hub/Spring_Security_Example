package com.example.Spring_Security_Example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Spring_Security_Example.Entities.Users;
import com.example.Spring_Security_Example.Repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public Users registerUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		Users add = repo.save(user);
		return add;
	}

}
