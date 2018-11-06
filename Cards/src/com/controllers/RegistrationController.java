package com.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.models.User;
import com.services.interfaces.CredentialsBusinessServiceInterface;
import com.utils.FieldChecker;


/**
 * 
 * @author Ali Cooper
 * Controller for regisitration based pages
 */
@Controller
public class RegistrationController {
	
private CredentialsBusinessServiceInterface credentialsService;
	
	/**
	 * injects Credentials service
	 * @param businessService
	 */
	@Autowired
	public void setLoginService(CredentialsBusinessServiceInterface businessService) {
		this.credentialsService = businessService;
	}
	
	
	/**
	 * 
	 * @param user
	 * @param result
	 * @param map
	 * @return
	 */
	@GetMapping("/register")
	public String registerPage(@Valid @ModelAttribute("user")User user, BindingResult result, ModelMap map) {
		map.addAttribute("user",new User());		
		return "register";
	}	
	
	/**
	 * attempts to register a user
	 * @param user
	 * @param result
	 * @return
	 */
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user")User user, BindingResult result, ModelMap map) {
		
		map.addAttribute("user", user);
		
		if (FieldChecker.hasError(result, "username", "password", "email", "firstName", "lastName")) {
			return "register";
		}
		
		// try to register user, will return false
		// if user is already registered
		if (!credentialsService.tryRegisterUser(user)) {
			map.addAttribute("message", "You are already registered, please login");
		} else {
			map.addAttribute("message", "You have been successfully registered");
		}

		return "login";

	}

	
}
