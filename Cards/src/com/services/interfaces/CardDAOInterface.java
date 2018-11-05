package com.services.interfaces;

import java.util.List;

import com.models.Card;

public interface CardDAOInterface extends GenericDAOInterface<Card> {
	
	public List<Card> findCardsByDeckId(int deckId);
	
}
