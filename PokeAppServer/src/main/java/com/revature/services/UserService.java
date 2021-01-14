package com.revature.services;




import com.revature.models.Users;

public interface UserService {
	
	public Users saveUser(Users user);
	
	public Users findUserById(int id);
	
	

}
