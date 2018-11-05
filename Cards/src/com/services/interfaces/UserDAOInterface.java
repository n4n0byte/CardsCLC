package com.services.interfaces;

import com.models.User;

public interface UserDAOInterface extends GenericDAOInterface<User>{
	
	public User findByUsername(String Username);
	
}
