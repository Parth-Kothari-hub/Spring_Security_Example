package com.example.Spring_Security_Example.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// This code bypass the security
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity	http) throws Exception {
//		return http.build();
//	}

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.csrf(custom -> custom.disable()).authorizeHttpRequests(req -> req.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
	}

	// Decrypt password from database
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
//	//No encrypted password directly password store in database
//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		provider.setUserDetailsService(userDetailsService);
//		return provider;
//	}

//	//Default service for login is UserDetailsService now it's implemented default service 
//	//It's not good approach it's behind the service what actually works.
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails user1 = User.withDefaultPasswordEncoder()
//				.username("User1")
//				.password("1234")
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(user1);
//	}

}
