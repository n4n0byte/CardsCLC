package com.services.interfaces;

import java.util.Optional;

import com.models.Card;

/**
 * 
 * @author Ali Cooper
 *
 */
public interface ICardBusinessService {
	
	public boolean addCard(Card card);
	
	public boolean addCardToDeckByDeckId(Card card, int deckId);
	
	public boolean addCardToDeckByUserId(Card card, int userId);
	
	public Card findCardById(int id);
	
	public Card findCardByUserId(int id);
	
	public Card findCardByTitle(String title);
	
	public boolean updateCard(Card card);
	
	public boolean deleteCardById(int id);
	
	public boolean deleteCard(Card card);
}
