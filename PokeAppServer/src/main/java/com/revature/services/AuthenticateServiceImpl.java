package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Users;
import com.revature.repositories.UserDao;



@Service
public class AuthenticateServiceImpl implements AuthenticateService {

	
	private UserDao userDao;
	
	
	
	@Autowired
	public AuthenticateServiceImpl(UserDao userDao) {

		this.userDao = userDao;
	}



	public Users authUser(Users user) {
		// TODO Auto-generated method stub
		return userDao.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
	}

}
