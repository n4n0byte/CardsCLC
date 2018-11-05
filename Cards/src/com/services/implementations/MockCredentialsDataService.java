package com.services.implementations;

import com.models.User;
import com.services.interfaces.CredentialsDataServiceInterface;

public class MockCredentialsDataService implements CredentialsDataServiceInterface{

	@Override
	public boolean isRegistered(User user) {
		return true;
	}

	@Override
	public boolean tryRegisterUser(User user) {
		return true;
	}

	@Override
	public boolean isValidCredentials(User user) {
		return true;
	}
	
	
	
}
