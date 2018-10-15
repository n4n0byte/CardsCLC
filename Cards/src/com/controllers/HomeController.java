package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.services.interfaces.IDeckBusinessService;

@Controller
public class HomeController {
	
	IDeckBusinessService IDeckBusinessService;
	
	@Autowired
	public void setIDeckBusinessService(IDeckBusinessService iDeckBusinessService) {
		IDeckBusinessService = iDeckBusinessService;
	}
	
	@GetMapping("addDeck")
	public String showAddDeck() {
		
		return "addDeck";
	
	}
	
	
}
