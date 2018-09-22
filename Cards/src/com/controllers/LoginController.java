package com.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.models.User;
import com.services.interfaces.ILoginBusinessService;

@Controller
public class LoginController {
	
	private ILoginBusinessService loginService;
	
	@Autowired
	public void setLoginService(ILoginBusinessService loginService) {
		this.loginService = loginService;
	}
	
	
	@GetMapping("/")
	public ModelAndView login(@Valid @ModelAttribute("user")User user, BindingResult result) {
		
		if (result.hasErrors()) {
			return new ModelAndView("login", "user", user);
		}
		
		return new ModelAndView("login", "user", new User());
	}
	
}
