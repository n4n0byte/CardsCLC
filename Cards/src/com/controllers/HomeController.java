package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.interfaces.ICardBusinessService;
import com.services.interfaces.IDeckBusinessService;

@Controller
public class HomeController {
	
	ICardBusinessService iCardBusinessService;
	IDeckBusinessService IDeckBusinessService;
	
	@Autowired
	public void setIDeckBusinessService(IDeckBusinessService iDeckBusinessService) {
		IDeckBusinessService = iDeckBusinessService;
	}

	@Autowired
	public void setiCardBusinessService(ICardBusinessService iCardBusinessService) {
		this.iCardBusinessService = iCardBusinessService;
	}
	
	@GetMapping("addDeck")
	public String showAddDeck() {
		
		return "addDeck";
	
	}
	
	
}
