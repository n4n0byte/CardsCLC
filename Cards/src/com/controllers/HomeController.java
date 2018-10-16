package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.models.Card;
import com.models.CardWithDeckTitle;
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
		modelMap.addAttribute("decks", IDeckBusinessService.findAllDecksByUsername(user.getUsername()));
		return "home";
	}
	
	@GetMapping("/newCard/{deckTitle}")
	public ModelAndView addNewCard(@PathVariable("deckTitle") String title, Card card, ModelMap map) {

		System.out.println("DECK NAME: " + title);
		ModelAndView res = new ModelAndView();
		
		res.addObject("cardWithDeckTitle", new CardWithDeckTitle(card, title));
		res.setViewName("newCard");
		return res;
	}
	
	@GetMapping("newDeck")
	public String addNewDeck (Deck deck,ModelMap map) {
		map.addAttribute("deck", new Deck());
		map.addAttribute("message", "Added Deck");
		return "newDeck";
	}
		
	
}
