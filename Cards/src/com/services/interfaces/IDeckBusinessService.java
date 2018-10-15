package com.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.models.Card;
import com.models.Deck;

public interface IDeckBusinessService {
	
	public Deck findDeckById(int id);
	public List<Deck> findAllDecksByUsername(String username);
	public List<Deck> findAllDecksByUserId(int username);
	public List<Card> getAllCardsInDeck(int deckId);
	public void updateDeck(Deck deck);
	public boolean deleteDeckById(int id);
	public boolean deleteDeck(Deck card);
	public boolean addCardToDeckWithDeckId(Card card, int deckId);
	
}
