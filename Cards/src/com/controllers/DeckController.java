package com.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.models.Card;
import com.models.Deck;
import com.models.User;
import com.services.interfaces.IDeckBusinessService;
import com.utils.FieldChecker;

@Controller
public class DeckController {

	IDeckBusinessService IDeckBusinessService;
	
	@Autowired
	public void setIDeckBusinessService(IDeckBusinessService iDeckBusinessService) {
		IDeckBusinessService = iDeckBusinessService;
	}

	@PostMapping("addDeck")
	public String addDeck(@Valid @ModelAttribute("deck")Deck deck, ModelMap modelMap, BindingResult result) {
		
		//validate only username and password
		if (FieldChecker.hasError(result, "title", "description")) {
			modelMap.put("message", "Validation Error");
			return "addDeck";
		}
		
		modelMap.put("message", "Successfully Added Deck");
		return "home";
	}
	
	@PostMapping("addCard")
	public String addCard(@Valid @ModelAttribute("card")Card card, ModelMap modelMap, BindingResult result) {
		
		//validate only title and description
		if (FieldChecker.hasError(result, "title", "description")) {
			modelMap.put("message", "Validation Error");
			return "newCard";
		}
		
		modelMap.put("message", "Successfully Added Deck");
		
		return "home";
		
	}
	
}
