package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import services.implementations.MockLoginBusinessService;
import services.implementations.MockLoginDataService;
import services.interfaces.ILoginBusinessService;
import services.interfaces.ILoginDataService;

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
