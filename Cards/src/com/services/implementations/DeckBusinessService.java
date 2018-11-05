package com.services.implementations;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.models.Card;
import com.models.Deck;
import com.models.User;
import com.services.interfaces.CardDAOInterface;
import com.services.interfaces.DeckBusinessServiceInterface;
import com.services.interfaces.DeckDAOInterface;

public class DeckBusinessService implements DeckBusinessServiceInterface {
	
	DeckDAOInterface iDeckDataService;
	CardDAOInterface cardSvc;
	
	
	@Autowired
	public void setCardSvc(CardDAOInterface cardSvc) {
		this.cardSvc = cardSvc;
	}


	@Autowired
	public void setiDeckDataService(DeckDAOInterface iDeckDataService) {
		this.iDeckDataService = iDeckDataService;
	}

			
	@Override
	public List<Deck> getDeckByUserId(int id) {
		
		return iDeckDataService.findAllDecksByUserId(id);
		
	}

	
	@Override
	public List<Deck> findAllDecksByUserId(int id) {
		return iDeckDataService.findAllDecksByUserId(id);
	}
	
	

	@Override
	public void updateDeck(Deck deck) {
		iDeckDataService.updateByModelById(deck, deck.getUserId());
	}

	@Override
	public boolean deleteDeckById(int id) {
		return iDeckDataService.deleteById(id);
	}

	@Override
	public void addCardToDeckWithDeckId(Card card, int deckId) {
		card.setDeckId(deckId);
		cardSvc.addModel(card);	
	}



	@Override
	public List<Deck> findAllDecksByUsername(String username) {
		return null;
	}
	
	@Override
	public boolean deleteDeckByTitle(String title) {
		return iDeckDataService.deleteByTitle(title);
	}


	@Override
	public List<Card> getAllCardsFromUser(User id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void addDeck(Deck deck) {
		iDeckDataService.addModel(deck);
	}



	@Override
	public void addCardToDeckWithDeckTitle(Card card, String deckTitle) {
		card.setDeckId(iDeckDataService.getByTitle(deckTitle).getDeckId());
		cardSvc.addModel(card);
	}


	@Override
	public Deck findDeckByDeckId(int deckId) {
		return iDeckDataService.getById(deckId);
	}



}
