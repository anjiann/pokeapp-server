package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Teams;
import com.revature.repositories.TeamsDao;

@Service
public class TeamServiceImp implements TeamService {

	
	
	private TeamsDao teamsDao;
	
	
	
	@Autowired
	public TeamServiceImp(TeamsDao teamsDao) {
	
		this.teamsDao = teamsDao;
	}

	@Override
	public Teams addTeam(Teams team)  {
		// TODO Auto-generated method stub
		return teamsDao.saveAndFlush(team);
	}

	@Override
	public Boolean deletTeam(int id) {
		// TODO Auto-generated method stub
		Boolean teamDeleted = true;
		try {
	   teamsDao.deleteById(id);
	   return teamDeleted;
		}
		catch(Exception e) {
		return	teamDeleted = false;
		}
	}

	@Override
	public Teams getOneTeam(int id) {
		// TODO Auto-generated method stub
		return teamsDao.getOne(id);
	}

}
