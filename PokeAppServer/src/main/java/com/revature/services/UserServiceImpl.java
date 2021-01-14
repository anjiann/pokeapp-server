package com.revature.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Favorite;
import com.revature.models.Users;
import com.revature.repositories.FavoriteDao;
import com.revature.repositories.UserDao;




@Service
public class UserServiceImpl implements UserService {

	
	private UserDao userDao;
	
	
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {

		this.userDao = userDao;
		
	}



	@Override
	public Users saveUser(Users user) {
		// TODO Auto-generated method stub
		return userDao.saveAndFlush(user) ;
	}



	@Override
	public Users findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getOne(id);
	}



	
}
