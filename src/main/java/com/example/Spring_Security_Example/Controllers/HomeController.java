package com.example.Spring_Security_Example.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

	//cOMMMENT ADDED.
	@GetMapping("/")
	public String greet(HttpServletRequest request) {
		return "Hello " + request.getSession().getId();
	}
}
