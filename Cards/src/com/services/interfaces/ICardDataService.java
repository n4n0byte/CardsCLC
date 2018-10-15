package com.services.interfaces;

import java.util.Optional;

import com.models.Card;

/**
 * 
 * @author Ali Cooper
 * specifies methods signatures for
 * 
 *
 */
public interface ICardDataService {
	
	public boolean addCardToDeckByDeckId(Card card, int deckId);
	public boolean addCardToDeckByUserId(Card card, int userId);
	public boolean addCardToDeckByDeckName(Card card, int deckId);
	
	public Card findCardById(int id);
	public Card findCardByUserId(int id);
	
	public Card findCardByTitle(String title);
	
	
	public void updateCard(Card card);
	
	public boolean deleteCardById(int id);
	public boolean deleteCard(Card card);

}
