package com.revature.services;

import com.revature.models.Teams;

public interface TeamService {

	public Teams addTeam(Teams team);
	
	public Boolean deletTeam(int id);
	
	public Teams getOneTeam(int id);
	
}
