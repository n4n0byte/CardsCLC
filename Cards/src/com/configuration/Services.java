package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.services.implementations.MockCredentialsBusinessService;
import com.services.implementations.MockCredentialsDataService;
import com.models.Deck;
import com.services.implementations.DeckBusinessService;
import com.services.implementations.DeckDAO;
import com.services.implementations.MockDeckDataService;
import com.services.interfaces.CredentialsBusinessServiceInterface;
import com.services.interfaces.CredentialsDataServiceInterface;
import com.services.interfaces.DeckBusinessServiceInterface;
import com.services.interfaces.DeckDAOInterface;

/**
 * 
 * @author Ali Cooper
 * IoC Configuration class for services
 */
@Configuration
public class Services {
	
	@Bean
    @Primary
	public CredentialsBusinessServiceInterface loginBusinessService() {
		return new MockCredentialsBusinessService();
	}
	
	@Bean
	@Primary
	public CredentialsDataServiceInterface loginDataService() {
		return new MockCredentialsDataService();
	}
	
	@Bean
	@Primary
	public DeckBusinessServiceInterface iDeckBusinessService() {
		return new DeckBusinessService();
	}
	
	@Bean
	@Primary
	public DeckDAOInterface deckDAOService() { 
		DeckDAOInterface deckDAO = new DeckDAO();
		return deckDAO;
	}
			
}
