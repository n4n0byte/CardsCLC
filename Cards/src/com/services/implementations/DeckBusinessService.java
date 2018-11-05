package com.services.implementations;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.models.Card;
import com.models.Deck;
import com.models.User;
import com.services.interfaces.DeckBusinessServiceInterface;
import com.services.interfaces.DeckDAOInterface;

public class DeckBusinessService implements DeckBusinessServiceInterface {
	
	DeckDAOInterface iDeckDataService;
	
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
		iDeckDataService.updateByModelById(deck, deck.getDeckId());
	}

	@Override
	public boolean deleteDeckById(int id) {
		return iDeckDataService.deleteById(id);
	}

	@Override
	public boolean addCardToDeckWithDeckId(Card card, int deckId) {
		return iDeckDataService.addCardToDeckWithDeckId(card, deckId);		
	}



	@Override
	public List<Deck> findAllDecksByUsername(String username) {
		return null;
	}



	@Override
	public boolean deleteDeck(Deck deck) {
		// TODO Auto-generated method stub
		return false;
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
	public void addCardToDeckWithDeckId(Card card, String deckTitle) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addCardToDeck(Card card, String deckTitle) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void findDeckByDeckId(int deckId) {
		// TODO Auto-generated method stub
		
	}



}
