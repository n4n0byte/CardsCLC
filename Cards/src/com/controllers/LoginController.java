package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.models.Card;
import com.models.Deck;
import com.models.User;
import com.services.implementations.DeckDAO;
import com.services.interfaces.CredentialsBusinessServiceInterface;
import com.services.interfaces.DeckDAOInterface;
import com.utils.FieldChecker;

/**
 * 
 * @author Ali Cooper
 * Login Controller 
 */
@Controller
public class LoginController {
	
	private CredentialsBusinessServiceInterface credentialsService;
	private DeckDAOInterface deckDao;
	
	
	@Autowired
	public void setDeckDao(DeckDAOInterface deckDao) {
		this.deckDao = deckDao;
	}

	@Autowired
	public void setLoginService(CredentialsBusinessServiceInterface businessService) {
		this.credentialsService = businessService;
	}
	
	
	
	/**
	 * home page for login
	 * @return
	 */
	@GetMapping("/")
	public ModelAndView login() {
		Deck deck = new Deck();
		List<Deck> de = deckDao.findAllDecksByUserId(1);
		
		for (Deck d : de) {
			System.out.println(d);
		}
		
		return new ModelAndView("login", "user", new User());
	}
	
	/**
	 * logs user in, will redirect to login 
	 * if there are validation errors
	 * @param user
	 * @param result
	 * @return ModelAndView
	 */
	@PostMapping("/login")
	public String doLogin(@Valid @ModelAttribute("user")User user, BindingResult result, ModelMap map, HttpServletRequest request) {

		map.addAttribute("user", user);
		
		//validate only username and password
		if (FieldChecker.hasError(result, "username", "password")) {
			return "login";
		}
	
		// check to see if credentials are valid
		if (!credentialsService.isValidCredentials(user)) {
			map.addAttribute("message", "Wrong Username or Password");
			return "login";
		}
			
		request.getSession().setAttribute("user", user);
		return "redirect:/home";
	}
	
	
}
