package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Favorite;

public interface FavoriteDao extends JpaRepository<Favorite, Integer> {

}
