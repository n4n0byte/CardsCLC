package com.services.implementations;

import java.util.Optional;

import com.models.Card;
import com.services.interfaces.ICardDataService;

public class MockCardDataService implements ICardDataService{

	@Override
	public void addCard(Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addCardToDeckByDeckId(Card card, int deckId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCardToDeckByUserId(Card card, int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Card> findCardById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Card> findCardByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Card> findCardByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCard(Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteCardById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCard(Card card) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
