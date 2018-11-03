package com.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.models.Card;
import com.models.Deck;

/**
 *
 * @author Ali Cooper, Anthony Natvidad
 *
 */
public interface IDeckDataService2 {
	
	public Deck findDeckById(int id);
	
	public List<Deck> findAllDecksByUsername(String username);
	public boolean addDeck(Deck deck);
	public List<Deck> findAllDecksByUserId(int username);
	public void updateDeck(Deck deck);
	public boolean deleteDeckById(int id);
	public boolean deleteDeck(Deck card);
	public boolean addCardToDeckWithDeckId(Card card, int deckId);
	public boolean addCardToDeckWithDeckTitle(Card card, String deckTitle);
	public Card findCardById(int id);
	public Card findCardByTitle(String title);
	public List<Card> findCardsByUserId(int userId);

}
