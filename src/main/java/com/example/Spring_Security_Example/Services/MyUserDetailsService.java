package com.example.Spring_Security_Example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Spring_Security_Example.Entities.Users;
import com.example.Spring_Security_Example.Models.UserPrincipal;
import com.example.Spring_Security_Example.Repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = repo.findByUserName(username);
		
		if(user == null) {
			System.out.println("User not found!!");
			throw new UsernameNotFoundException("User not found!!");
		}
		
		return new UserPrincipal(user);
	}

}
