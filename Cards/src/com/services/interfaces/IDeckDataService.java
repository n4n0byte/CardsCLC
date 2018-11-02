package com.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.models.Card;
import com.models.Deck;

/**
 *
 * @author Ali Cooper
 *
 */
public interface IDeckDataService {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Deck findDeckById(int id);
	/**
	 * 
	 * @param username
	 * @return
	 */
	public List<Deck> findAllDecksByUsername(String username);
	/**
	 * 
	 * @param deck
	 * @return
	 */
	public boolean addDeck(Deck deck);
	/**
	 * 
	 * @param username
	 * @return
	 */
	public List<Deck> findAllDecksByUserId(int username);
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
	 * @param card
	 * @return
	 */
	public boolean deleteDeck(Deck card);
	/**
	 * 
	 * @param card
	 * @param deckId
	 * @return
	 */
	public boolean addCardToDeckWithDeckId(Card card, int deckId);
	/**
	 * 
	 * @param card
	 * @param deckTitle
	 * @return
	 */
	public boolean addCardToDeckWithDeckTitle(Card card, String deckTitle);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Card findCardById(int id);
	/**
	 * 
	 * @param title
	 * @return
	 */
	public Card findCardByTitle(String title);
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<Card> findCardsByUserId(int userId);

}
