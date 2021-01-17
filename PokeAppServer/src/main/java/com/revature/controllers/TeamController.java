package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.TeamList;
import com.revature.models.Teams;
import com.revature.services.TeamListServiceImp;
import com.revature.services.TeamServiceImp;

@RestController
@RequestMapping("/team")
public class TeamController {

	private TeamServiceImp temImp;
	
	private TeamListServiceImp teamListImp;

	@Autowired
	public TeamController(TeamServiceImp temImp, TeamListServiceImp teamListImp) {
	
		this.temImp = temImp;
		this.teamListImp = teamListImp;
	}
	
	
	
	// takes in teams name and user id of the ream owner and creates the team 
	
	@PostMapping
	public ResponseEntity<Teams> addTeam(@RequestBody Teams teams){
		
		
		return new ResponseEntity<Teams>(temImp.addTeam(teams), HttpStatus.CREATED);
		
	}
	
	
	// takes in team id and remve the team form the particuler user record 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Teams> deletTeam(@PathVariable int id) {
		
		if(temImp.deletTeam(id)) { 
		 return new ResponseEntity<Teams>( HttpStatus.OK);
		}
		else {
		return new ResponseEntity<Teams>( HttpStatus.UNAUTHORIZED);
		}
		
		
	}
	
	// this will add the pokemon in the list must need pokemon id and list id in which pokemon need to be added 
	
	@PostMapping("/addpoke")
	public ResponseEntity<TeamList> addPokeInList(@RequestBody TeamList teamList){
		
		try {
		
			return new ResponseEntity<TeamList>(teamListImp.addPokeInTeam(teamList), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<TeamList>( HttpStatus.UNAUTHORIZED);
		}
		
		
		
	}
	
	// this will takes in team id and return the list of pokemon in that perticuler list 
	
	@GetMapping("/{id}")
	public ResponseEntity<List<TeamList>> getOneTeam(@PathVariable int id){
		
		try {
		     Teams one = temImp.getOneTeam(id);
		
		return new ResponseEntity<List<TeamList>>(one.getTeamList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<TeamList>>( HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	// this will take id of the perticuler teamList and delet the perticuler pokimon form the list
	
	@DeleteMapping("/deletpoke/{id}")
	public ResponseEntity<TeamList> deletPokeFromTeamById(@PathVariable int id) {
		
		if(teamListImp.deletPokeInTema(id)) { 
		 return new ResponseEntity<TeamList>( HttpStatus.OK);
		}
		else {
		return new ResponseEntity<TeamList>( HttpStatus.UNAUTHORIZED);
		}
		
		
	}
	
	
}
