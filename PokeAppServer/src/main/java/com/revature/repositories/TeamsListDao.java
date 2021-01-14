package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.TeamList;

public interface TeamsListDao extends JpaRepository<TeamList, Integer> {

}
