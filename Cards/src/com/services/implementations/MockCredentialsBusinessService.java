package com.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.models.User;
import com.services.interfaces.ICredentialsBusinessService;
import com.services.interfaces.ICredentialsDataService;

/**
 * 
 * @author Ali Cooper
 * TODO add docs
 *
 */
public class MockCredentialsBusinessService implements ICredentialsBusinessService{
	
	// TODO add data service
	private ICredentialsDataService credentialsService;
	
	@Autowired
	public void setCredentialsService(ICredentialsDataService credentialsService) {
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
