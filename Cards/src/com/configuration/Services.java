package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.services.implementations.MockLoginBusinessService;
import com.services.implementations.MockLoginDataService;
import com.services.interfaces.ILoginBusinessService;
import com.services.interfaces.ILoginDataService;

@Configuration
public class Services {
	
	@Bean
    @Primary
	public ILoginBusinessService loginBusinessService() {
		return new MockLoginBusinessService();
	}
	
	@Bean
	@Primary
	public ILoginDataService loginDataService() {
		return new MockLoginDataService();
	}
	
	
}
