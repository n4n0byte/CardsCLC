package com.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.models.Card;
import com.models.User;
import com.services.interfaces.IDeckBusinessService;

@Controller
public class HomeController {
	
	IDeckBusinessService IDeckBusinessService;
	
	@Autowired
	public void setIDeckBusinessService(IDeckBusinessService iDeckBusinessService) {
		IDeckBusinessService = iDeckBusinessService;
	}
	
	@GetMapping("home")
	public String home(ModelMap modelMap, HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		modelMap.addAttribute("decks",IDeckBusinessService.getAllDecksByUser(user));
		return "home";
	}
	
	@GetMapping("newCard")
	public String addNewCard(HttpServletRequest request, ModelMap map) {
		map.addAttribute("card", new Card());
		return "newCard";
	}
	
	@GetMapping("newDeck/{title}")
	public String addNewDeck (ModelMap map, @PathVariable String title) {
		
		map.addAttribute("card", new Card());
		return "newDeck";
	}
	
	@GetMapping("addDeck")
	public String showAddDeck() {
		return "addDeck";
	
	}
	
	
}
