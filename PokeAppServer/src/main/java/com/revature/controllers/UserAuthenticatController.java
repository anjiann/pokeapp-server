package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Users;
import com.revature.services.AuthenticateService;


@RestController
@RequestMapping("/auth")
public class UserAuthenticatController {

	private AuthenticateService authenticateService;
	

	@Autowired
	public UserAuthenticatController(AuthenticateService authenticateService ) {
		
		this.authenticateService = authenticateService;
		
	}
	
	
	
	// if the user name and password is true will return user else 401 response 
	
	@PostMapping
	public ResponseEntity<Users> saveUser(@RequestBody Users user){
		

		
		if(authenticateService.authUser(user)== null) {
			
			return new ResponseEntity<Users>(  HttpStatus.UNAUTHORIZED);
		}
		else {
			return new ResponseEntity<Users>(authenticateService.authUser(user), HttpStatus.OK);
		}
		

	
	}	
}
