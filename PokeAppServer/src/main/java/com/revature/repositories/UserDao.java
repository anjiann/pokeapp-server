package com.revature.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Users;

public interface UserDao extends JpaRepository<Users, Integer> {
	
	
	public Users findByUserNameAndUserPassword(String userName, String userPassword);

}
