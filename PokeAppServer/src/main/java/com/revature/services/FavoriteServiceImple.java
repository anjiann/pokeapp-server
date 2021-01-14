package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Favorite;
import com.revature.repositories.FavoriteDao;



@Service
public class FavoriteServiceImple implements FavoriteService {
	
	
	
	private FavoriteDao favDao;
	
	
	
	@Autowired
	public FavoriteServiceImple(FavoriteDao favDao) {
	
		this.favDao = favDao;
	}




	@Override
	public Favorite saveFavorite(Favorite favotrite) {
		// TODO Auto-generated method stub
		return favDao.saveAndFlush(favotrite);
	}




	@Override
	public Boolean removeFavorite(int favId) {
		// TODO Auto-generated method stub
		Boolean deletaed = true; 
		try {
		favDao.deleteById(favId);	
		
		}
		catch (Exception e) {
			// TODO: handle exception
			deletaed = false;
		}
		return deletaed;
	}

}
