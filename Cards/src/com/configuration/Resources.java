package com.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class Resources implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	   registry
    	   		.addResourceHandler("/resources/**")
    	   		.addResourceLocations("/WEB-INF/resources/");
    	   registry
    	   		.addResourceHandler("/public/**")
    	   		.addResourceLocations("classpath:/public/");
      }
}