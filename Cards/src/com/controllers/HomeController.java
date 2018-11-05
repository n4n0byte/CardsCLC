package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.models.Card;
import com.models.CardWithDeckTitle;
import com.models.Deck;
import com.models.User;
import com.services.interfaces.DeckBusinessServiceInterface;

@Controller
public class HomeController {
	
	DeckBusinessServiceInterface IDeckBusinessService;
	/*Implents the IDeckBusinessService allowing us to add cards to a deck or create a new deck by going through the businesslogic of the application*/
	@Autowired
	public void setIDeckBusinessService(DeckBusinessServiceInterface iDeckBusinessService) {
		IDeckBusinessService = iDeckBusinessService;
	}
	
	/*Displays the current decks the user has made by returning an ArrayList of decks*/
	@GetMapping("home")
	public String home(ModelMap modelMap, HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		
		List<Deck> decks = IDeckBusinessService.findAllDecksByUserId(user.getId());
		System.out.println(user);
		for (Deck c : decks) {
			System.out.println(c);
		}
		
		modelMap.addAttribute("decks", decks);
		return "home";
	}
	
	/*Takes you to the add Card to deck view page
	 * Uri is dependent on which deck is clicked
	 * Deck is updated
	 * */
	@GetMapping("/newCard/{deckTitle}")
	public ModelAndView addNewCard(@PathVariable("deckTitle") String title, Card card, ModelMap map, RedirectAttributes attrs) {

		System.out.println("DECK NAME: " + title);
		ModelAndView res = new ModelAndView();
		
		res.addObject("cardWithDeckTitle", new CardWithDeckTitle(card, title));
		res.setViewName("newCard");
		return res;
	}
	
	/*Takes you to the newDeck view page
	 * To make deck you enter Title and Description
	 * */
	@GetMapping("newDeck")
	public String addNewDeck (Deck deck,ModelMap map) {
		map.addAttribute("deck", new Deck());
		map.addAttribute("message", "Added Deck");
		return "newDeck";
	}
		
	
}
