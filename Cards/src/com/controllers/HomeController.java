package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.models.Card;
import com.models.Deck;
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
	public String addNewCard(Deck deck, ModelMap map) {
		map.addAttribute("card", new Card());
		map.addAttribute("deckTitle",deck.getTitle());
		return "newCard";
	}
	
	@GetMapping("newDeck")
	public String addNewDeck (BindingResult result,ModelMap map) {
		
		return "newDeck";
	}
	
	@GetMapping("addDeck")
	public String showAddDeck() {
		return "addDeck";
	
	}
	
	
}
