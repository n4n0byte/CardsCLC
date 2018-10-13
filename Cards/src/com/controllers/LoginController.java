 package com.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.models.User;
import com.services.interfaces.ICredentialsBusinessService;

import com.utils.FieldChecker;

/**
 * 
 * @author Ali Cooper
 * Login Controller 
 */
@Controller
public class LoginController {
	
	private ICredentialsBusinessService credentialsService;
	
	@Autowired
	public void setLoginService(ICredentialsBusinessService businessService) {
		this.credentialsService = businessService;
	}
	
	/**
	 * home page for login
	 * @return
	 */
	@GetMapping("/")
	public ModelAndView login() {
		return new ModelAndView("login", "user", new User());
	}
	
	/**
	 * logs user in, will redirect to login 
	 * if there are validation errors
	 * @param user
	 * @param result
	 * @return ModelAndView
	 */
	@PostMapping("/login")
	public String home(@Valid @ModelAttribute("user")User user, BindingResult result, ModelMap map) {
				
		//validate only username and password
		if (FieldChecker.hasError(result, "username", "password")) {
			map.addAttribute("user", user);
			return "login";
		}
	
		// check to see if credentials are valid
		if (!credentialsService.isValidCredentials(user)) {
			map.addAttribute("message", "Wrong Username or Password");
			return "login";
		}
		
		return "home";
	}
	
	
}
