package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.TeamList;

import com.revature.repositories.TeamsListDao;



@Service
public class TeamListServiceImp implements TeamsListService {

	
	private TeamsListDao teamsListDao;
	
	
	@Autowired
	public TeamListServiceImp(TeamsListDao teamsListDao) {
	
		this.teamsListDao = teamsListDao;
	}

	@Override
	public TeamList addPokeInTeam(TeamList teamList) {

		return teamsListDao.saveAndFlush(teamList);
			
		
	}

	@Override
	public Boolean deletPokeInTema(int id) {
		// TODO Auto-generated method stub
		Boolean deletSuccess = true;
		
		try {
			teamsListDao.deleteById(id);
		}
		catch (Exception e) {
			// TODO: handle exception
			deletSuccess = false;
		}
		
		return deletSuccess;
	}
	


}
