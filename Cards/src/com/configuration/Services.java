package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.services.implementations.CardDAO;
import com.services.implementations.CredentialsBusinessService;
import com.services.implementations.DeckBusinessService;
import com.services.implementations.DeckDAO;
import com.services.implementations.UserDAO;
import com.services.interfaces.CardDAOInterface;
import com.services.interfaces.CredentialsBusinessServiceInterface;
import com.services.interfaces.DeckBusinessServiceInterface;
import com.services.interfaces.DeckDAOInterface;
import com.services.interfaces.UserDAOInterface;

/**
 * 
 * @author Ali Cooper
 * IoC Configuration class for services
 */
@Configuration
public class Services {
	

	@Bean
	@Primary
	public UserDAOInterface loginDataService() {
		return new UserDAO();
	}
	
	@Bean
	@Primary
	public DeckBusinessServiceInterface iDeckBusinessService() {
		return new DeckBusinessService();
	}
		
	@Bean
	@Primary
	public CardDAOInterface cardDAOService() {
		return new CardDAO();
	}
	
	
	@Bean
	@Primary
	public DeckDAOInterface deckDAOService() { 
		DeckDAOInterface deckDAO = new DeckDAO();
		
		return deckDAO;
	}
	
	@Bean
	@Primary
	public CredentialsBusinessServiceInterface credentialsBusinessServiceInterface() {
		return new CredentialsBusinessService();
	}
	
			
}
