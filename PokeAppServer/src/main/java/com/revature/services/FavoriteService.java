package com.revature.services;

import com.revature.models.Favorite;

public interface FavoriteService {
	
	public Favorite saveFavorite(Favorite favotrite);
	
	public Boolean removeFavorite(int userid, int pokeid);

	

}
