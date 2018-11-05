package com.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.models.User;
import com.services.interfaces.CredentialsBusinessServiceInterface;
import com.services.interfaces.CredentialsDataServiceInterface;

/**
 * 
 * @author Ali Cooper
 * TODO add docs
 *
 */
public class MockCredentialsBusinessService implements CredentialsBusinessServiceInterface{
	
	// TODO add data service
	private CredentialsDataServiceInterface credentialsService;
	
	@Autowired
	public void setCredentialsService(CredentialsDataServiceInterface credentialsService) {
		System.out.println("INJECTING CREDENTIALS DATA SERVICE");
		this.credentialsService = credentialsService;
	}
	
	/**
	 * mock registration check
	 */
	@Override
	public boolean isRegistered(User user) {
		return credentialsService.isRegistered(user);
	}	
	
	/**
	 * mock registration
	 */
	@Override
	public boolean tryRegisterUser(User user) {
		return credentialsService.tryRegisterUser(user);
	}
	
	/**
	 * mock validation check
	 */
	@Override
	public boolean isValidCredentials(User user) {
		return credentialsService.isValidCredentials(user);
	}

	
}
