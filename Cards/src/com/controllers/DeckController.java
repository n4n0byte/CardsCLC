package com.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.models.CardWithDeckTitle;
import com.models.Deck;
import com.services.interfaces.IDeckBusinessService;
import com.utils.FieldChecker;

@Controller
public class DeckController {

	IDeckBusinessService IDeckBusinessService;
	
	@Autowired
	public void setIDeckBusinessService(IDeckBusinessService iDeckBusinessService) {
		IDeckBusinessService = iDeckBusinessService;
	}

	@PostMapping("createDeck")
	public String addDeck(@Valid @ModelAttribute("deck")Deck deck, ModelMap modelMap, BindingResult result) {
		
		//validate only username and password
		if (FieldChecker.hasError(result, "title", "description")) {
			modelMap.put("message", "Validation Error");
			return "addDeck";
		}
		
		IDeckBusinessService.addDeck(deck);
		
		modelMap.put("message", "Successfully Added Deck");
		return "redirect:/home";
	}	
	
	@PostMapping("addCard")
	public String addCard(@ModelAttribute("cardWithDeckTitle")CardWithDeckTitle cardWithDeckTitle, ModelMap modelMap, BindingResult result) {
		
		System.out.println("IN CARD: " + cardWithDeckTitle);
		
		//validate only title and description
		if (FieldChecker.hasError(result, "title", "description")) {
			modelMap.put("message", "Validation Error");
			return "newCard";
		}
		
		modelMap.put("message", "Successfully Added Card");
		IDeckBusinessService.addCardToDeck(cardWithDeckTitle.getCard(), cardWithDeckTitle.getDeckTitle());
		
		return "redirect:/home";
		
	}
	
}
