package com.services.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.models.Card;
import com.models.Deck;
import com.models.User;

public interface IDeckBusinessService {
	
	/**
	 * returns all decks given the username
	 * that created them
	 * @param username
	 * @return
	 */
	public List<Deck> findAllDecksByUsername(String username);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Deck> findAllDecksByUserId(int id);
	/**
	 * 
	 * @param deck
	 */
	public void updateDeck(Deck deck);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteDeckById(int id);
	/**
	 * 
	 * @param deck
	 * @return
	 */
	public boolean deleteDeck(Deck deck);
	/**
	 * 
	 * @param card
	 * @param deckId
	 * @return
	 */
	public boolean addCardToDeckWithDeckId(Card card, int deckId);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Deck> getDeckByUserId(int id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Deck findDeckByDeckId(int id);
	/**
	 * 
	 * @param deck
	 * @return
	 */
	public boolean addDeck(Deck deck);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Card> getAllCardsFromUser(User id);
	/**
	 * 
	 * @param card
	 * @param deckTitle
	 */
	void addCardToDeck(Card card, String deckTitle);

}
