package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.services.implementations.MockCredentialsBusinessService;
import com.services.implementations.MockCredentialsDataService;
import com.services.implementations.MockDeckBusinessService;
import com.services.interfaces.ICredentialsBusinessService;
import com.services.interfaces.ICredentialsDataService;
import com.services.interfaces.IDeckBusinessService;
import com.services.interfaces.IDeckDataService;

/**
 * 
 * @author Ali Cooper
 * IoC Configuration class for services
 */
@Configuration
public class Services {
	
	@Bean
    @Primary
	public ICredentialsBusinessService loginBusinessService() {
		return new MockCredentialsBusinessService();
	}
	
	@Bean
	@Primary
	public ICredentialsDataService loginDataService() {
		return new MockCredentialsDataService();
	}
	
	@Bean
	@Primary
	public IDeckBusinessService iDeckBusinessService() {
		return new MockDeckBusinessService();
	}
		
}
