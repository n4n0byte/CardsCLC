package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.models.CardWithDeckTitle;
import com.models.Deck;
import com.models.User;
import com.services.interfaces.DeckBusinessServiceInterface;
import com.utils.FieldChecker;

@Controller
public class DeckController {

	DeckBusinessServiceInterface IDeckBusinessService;
	
	@Autowired
	public void setIDeckBusinessService(DeckBusinessServiceInterface iDeckBusinessService) {
		IDeckBusinessService = iDeckBusinessService;
	}
	
	@PostMapping("displayDeck")
	public String displayDeck(@Valid @ModelAttribute("deck")Deck deck, ModelMap modelMap, BindingResult result, RedirectAttributes attrs, HttpServletRequest sess) {
		
		//validate only title and description
		if (FieldChecker.hasError(result, "title", "description")) {
			modelMap.put("message", "Validation Error");
			return "displayDeck";
		}
		
		IDeckBusinessService.addDeck(deck);
		
		modelMap.put("message", "Successfully Added Deck");
		User user = (User) sess.getAttribute("user");
		attrs.addFlashAttribute("decks", IDeckBusinessService.findAllDecksByUsername(user.getUsername()));

		return "displayDeck";
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
	
	@GetMapping("updateDeck/{deckTitle}")
	public ModelAndView updateDeck(@ModelAttribute("Deck")Deck deck, ModelMap modelMap, BindingResult result, RedirectAttributes attrs) {
		
		
		return new ModelAndView("updateDeck","Deck",new Deck());
		
	}
	@PostMapping("updateResponse")
	public String updateResponse(@ModelAttribute("Deck")Deck deck, ModelMap modelMap, BindingResult result) {
		
		//validate only title and description
		if (FieldChecker.hasError(result, "title", "description")) {
			modelMap.put("message", "Validation Error");
			return "updateResponse.jsp";
		}
		
		modelMap.put("message", "Successfully updated Deck");
		IDeckBusinessService.updateDeck(deck);
		return "redirect:/home";
		
	}	
	
	@GetMapping("deleteDeck/{deckTitle}")
	public String deleteDeck(@PathVariable("deckTitle") String title, ModelMap modelMap) {
		Deck deck = new Deck();
		deck.setTitle(title);
		IDeckBusinessService.deleteDeck(deck);
		
		return "redirect:/home";
		
	}
	
	@GetMapping("findById")
	public ModelAndView findById(@ModelAttribute("Deck")Deck deck, ModelMap modelMap, BindingResult result,RedirectAttributes attrs) {
		IDeckBusinessService.findDeckByDeckId(deck.getDeckId());
		return new ModelAndView("","Deck",new Deck());
		
	}
	@PostMapping("displayfindById")
	public String displayfindById(@ModelAttribute("Deck")Deck deck, ModelMap modelMap, BindingResult result) {
		
		//validate only title and description
		if (FieldChecker.hasError(result, "title", "description")) {
			modelMap.put("message", "Validation Error");
			return "displayFindByid.jsp";
		}
		
		modelMap.put("message", "Successfully updated Deck");
		IDeckBusinessService.updateDeck(deck);
		return "redirect:/home";
		
	}	
}
