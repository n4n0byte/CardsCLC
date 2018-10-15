package com.services.implementations;

import java.util.List;
import java.util.Optional;

import com.models.Card;
import com.models.Deck;
import com.services.interfaces.ICardBusinessService;
import com.services.interfaces.IDeckDataService;

public class MockDeckDataService implements IDeckDataService {

	@Override
	public Deck findDeckById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Deck> findAllDecksByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Deck> findAllDecksByUserId(int username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDeck(Deck deck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteDeckById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDeck(Deck card) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCardToDeckWithDeckId(Card card, int deckId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Card findCardById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card findCardByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card findCardByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
