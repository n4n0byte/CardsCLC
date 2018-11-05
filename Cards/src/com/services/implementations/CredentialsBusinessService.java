package com.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.models.User;
import com.services.interfaces.CredentialsBusinessServiceInterface;
import com.services.interfaces.UserDAOInterface;

public class CredentialsBusinessService implements CredentialsBusinessServiceInterface {

	private UserDAOInterface userDAO;

	@Autowired
	public void setUserDAO(UserDAOInterface userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean isRegistered(User user) {
		
		User usr = userDAO.findByUsername(user.getUsername());
		System.out.println(usr + "PRINT: USER REGISTERED");
		
		return true;
	}

	@Override
	public boolean tryRegisterUser(User user) {
		
		User usr = userDAO.findByUsername(user.getUsername());
		System.out.println(usr);
		if(usr == null) {
			userDAO.addModel(user);
			return true;
		}

		
		return false;
	}

	@Override
	public boolean isValidCredentials(User user) {
		User usr = userDAO.findByUsername(user.getUsername());
		System.out.println(usr);
		System.out.println(user);
		if(usr == null) return false;
		
		if (usr.getPassword().equals(user.getPassword()) && usr.getUsername().equals(user.getUsername())) {
			return true;
		}
		
				
		return false;
	}

}
