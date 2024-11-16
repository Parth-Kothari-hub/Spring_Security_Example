package com.example.Spring_Security_Example.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
	
	private Integer id;
	private String name;
	private Integer marks;
}
