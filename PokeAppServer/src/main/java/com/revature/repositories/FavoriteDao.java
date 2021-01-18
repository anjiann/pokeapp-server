package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.models.Favorite;

public interface FavoriteDao extends JpaRepository<Favorite, Integer> {
	
	@Query(value = "DELETE FROM project2.favorite WHERE fav_user_id =?1 and fav_list=?2 ", nativeQuery = true)
	public void deletByUserIdnadPokeID(int userID, int pokeID);

}
