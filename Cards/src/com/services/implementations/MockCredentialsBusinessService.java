package com.services.implementations;

import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;

import com.models.User;
import com.services.interfaces.ICredentialsBusinessService;
import com.services.interfaces.ICredentialsDataService;

public class MockCredentialsBusinessService implements ICredentialsBusinessService{
	
	// TODO add data service
	private ICredentialsDataService credentialsService;
	
	@Autowired
	public void setCredentialsService(ICredentialsDataService credentialsService) {
		System.out.println("INJECTING CREDENTIAL DATA SERVICE");
		this.credentialsService = credentialsService;
	}
	
	/**
	 * mock registration check
	 */
	@Override
	public boolean isRegistered(User user) {
		return true;
	}	
	
	/**
	 * mock registration
	 */
	@Override
	public boolean tryRegisterUser(User user) {
		return true;
	}
	
	/**
	 * mock validation check
	 */
	@Override
	public boolean isValidCredentials(User user) {
		return false;
	}

	
}
