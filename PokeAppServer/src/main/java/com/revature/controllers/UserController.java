package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Users;
import com.revature.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		
		this.userService = userService;
	}
	
	
	
	
	// Create New User if User with the same name already exixst it will send 403 Error cod 
	
	@PostMapping
	public ResponseEntity<Users> saveUser(@RequestBody Users user){
		
		try {
		
		return new ResponseEntity<Users>(userService.saveUser(user), HttpStatus.CREATED);
		}
		catch (Exception e) {
			// TODO: handle exception
			
			return new ResponseEntity<Users>(  HttpStatus.FORBIDDEN);
		}
		
	} 
	
	
	
	
	

}