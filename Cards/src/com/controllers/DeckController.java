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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.models.CardWithDeckTitle;
import com.models.Deck;
import com.models.User;
import com.services.interfaces.DeckBusinessServiceInterface;
import com.services.interfaces.GenericDAOInterface;
import com.utils.FieldChecker;
/**
 * 
 * @author Ali Cooper & Anthony Natividad
 * Handles all get and post mapping methods for deck modules in view pages
 * Implements DeckBusinessService
 */
@Controller
public class DeckController {

	GenericDAOInterface<Deck> deckSvc;
	
	@Autowired
	public void setIDeckBusinessService(GenericDAOInterface<Deck> iDeckBusinessService) {
		deckSvc = iDeckBusinessService;
	}
	
	@PostMapping("newDeck")
	public String newDeck(@Valid @ModelAttribute("deck")Deck deck,ModelMap modelMap, BindingResult result, HttpServletRequest sess) {
		if (FieldChecker.hasError(result, "title", "description")) {
			modelMap.put("message", "Validation Error");
			return "newDeck";
		}
		User user = (User) sess.getSession().getAttribute("user");
		deck.setUserId(user.getId());
		deckSvc.addModel(deck);
		return "redirect:/home";
	}
	
	@GetMapping("displayDeck/{deckId}")
	public String displayDeck(@PathVariable("deckId") int deckId,ModelMap modelMap, RedirectAttributes attrs, HttpServletRequest sess) {
				
		Deck deck = deckSvc.getById(deckId);
		System.out.println(deck);
		if (deck == null) {
			return "redirect:home";
		}
		
	
		modelMap.put("deck", deck);
		
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
		deckSvc.addCardToModelWithModelName(cardWithDeckTitle.getCard(), cardWithDeckTitle.getDeckTitle());
		
		return "redirect:/home";
		
	}	
	
	@GetMapping("updateDeck/{deckTitle}")
	public ModelAndView updateDeck(@ModelAttribute("Deck")Deck deck, ModelMap modelMap, BindingResult result, RedirectAttributes attrs) {
		
		
		return new ModelAndView("updateDeck","Deck",new Deck());
		
	}
	
	@PostMapping("updateResponse")
	public String updateResponse(@ModelAttribute("Deck")Deck deck, ModelMap modelMap, BindingResult result, HttpServletRequest req) {
		
		//validate only title and description
		if (FieldChecker.hasError(result, "title", "description")) {
			modelMap.put("message", "Validation Error");
			return "updateResponse.jsp";
		}
		
		modelMap.put("message", "Successfully updated Deck");
		System.out.println("DECKDECKDECK " + deck);
			User usr = (User) req.getSession().getAttribute("user");
		deck.setUserId(usr.getId());
		deckSvc.updateDeck(deck);
		return "redirect:/home";
		
	}	
	
	@GetMapping("deleteDeck/{deckTitle}")
	public String deleteDeck(@PathVariable("deckTitle") String title, ModelMap modelMap) {
		deckSvc.deleteDeckByTitle(title);
		return "redirect:/home";
		
	}
	
	@GetMapping("findById")
	public ModelAndView findById(@ModelAttribute("Deck")Deck deck, ModelMap modelMap, BindingResult result,RedirectAttributes attrs) {
		deckSvc.findDeckByDeckId(deck.getDeckId());
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
		deckSvc.updateDeck(deck);
		return "redirect:/home";
		
	}	
}
