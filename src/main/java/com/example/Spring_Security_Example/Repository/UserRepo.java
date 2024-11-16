package com.example.Spring_Security_Example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Spring_Security_Example.Entities.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByUserName(String userName);
}
