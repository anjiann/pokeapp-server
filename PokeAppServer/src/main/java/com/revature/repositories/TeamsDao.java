package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Teams;

public interface TeamsDao extends JpaRepository<Teams, Integer> {

	
}
