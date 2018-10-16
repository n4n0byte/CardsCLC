package com.services.implementations;

import com.models.User;
import com.services.interfaces.ICredentialsDataService;

public class MockCredentialsDataService implements ICredentialsDataService{

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
