package com.services.interfaces;

import com.models.User;

/**
 * 
 * @author Ali Cooper
 * 
 * interface for
 *
 */
public interface ICredentialsBusinessService {
	
	/**
	 * checks to see if user is registered
	 * @return
	 */
	public boolean isRegistered(User user);
	
	/**
	 * tries to register a user,
	 * returns true if successful and false if 
	 * not successful
	 * @param user
	 * @return Bool success
	 */
	public boolean tryRegisterUser(User user);
	
	/**
	 * checks to see if users 
	 * login info is valid
	 * @param user
	 * @return bool 
	 */
	public boolean isValidCredentials(User user);
		
}
