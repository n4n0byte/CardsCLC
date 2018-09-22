package com.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.models.User;
import com.services.interfaces.ICredentialsBusinessService;


@Controller
public class RegistrationController {
	
private ICredentialsBusinessService credentialsService;
	
	@Autowired
	public void setLoginService(ICredentialsBusinessService businessService) {
		this.credentialsService = businessService;
	}
	
	
	
	
	/**
	 * attempts to register a user
	 * @param user
	 * @param result
	 * @return
	 */
	@PostMapping("/register")
	public ModelAndView register(@Valid @ModelAttribute("user")User user, BindingResult result) {
		
		ModelAndView resultView;
		
		
		if (true) {
			resultView = new ModelAndView("login", "user", user);
		} 
		else if(!credentialsService.tryRegisterUser(user)) {
			resultView = new ModelAndView("register", "user", user);
		} else {
			resultView = new ModelAndView("home","user", user);
		}

		return resultView;

	}

	
}
