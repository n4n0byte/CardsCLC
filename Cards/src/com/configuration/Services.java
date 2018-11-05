package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.annotation.SessionScope;

import com.services.implementations.MockCredentialsBusinessService;
import com.services.implementations.MockCredentialsDataService;
import com.services.implementations.MockDeckBusinessService;
import com.services.implementations.MockDeckDataService;
import com.services.interfaces.CredentialsBusinessServiceInterface;
import com.services.interfaces.CredentialsDataServiceInterface;
import com.services.interfaces.DeckBusinessServiceInterface;
import com.services.interfaces.DeckDataServiceInterface;

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
		return new MockDeckBusinessService();
	}
	
	@Bean
	@Primary

	public DeckDataServiceInterface iDeckBusinessService1() {
		return new MockDeckDataService();
	}
			
}
