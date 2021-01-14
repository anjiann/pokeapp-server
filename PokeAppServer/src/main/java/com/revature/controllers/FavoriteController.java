package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Favorite;

import com.revature.services.FavoriteService;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
	
	
	private FavoriteService favService;

	@Autowired
	public FavoriteController(FavoriteService favService) {
		
		this.favService = favService;
	}
	
	
	@PostMapping
	public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite favorite){
		
		try{
		
		return new ResponseEntity<Favorite>(favService.saveFavorite(favorite), HttpStatus.CREATED);
		}
		catch (Exception e) {
			
			return new ResponseEntity<Favorite>( HttpStatus.NOT_FOUND);
		}
		
		
	}
	@GetMapping("/deletfav/{id}")
	public ResponseEntity<Favorite> removeFavorite(@PathVariable int id){
		
		if(favService.removeFavorite(id)) {
			
			return new ResponseEntity<Favorite>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Favorite>(HttpStatus.NOT_MODIFIED);
		}
	}
	
	
	

}
