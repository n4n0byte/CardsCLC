package com.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.models.Card;
import com.models.Collection;
import com.models.Deck;

/**
 * 
 * @author Ali Cooper
 * specifies methods signatures for
 *
 */
public interface ICardDataService {
	
	public void addCard(Card card);
	public void addCardToDeckByDeckId(Card card, int deckId);
	
	public Optional<Card> findCardById(int id);
	public Optional<Card> findCardByTitle(String title);
	
	
	public void updateCard(Card card);
	
	public Boolean deleteCardById(int id);
	public Boolean deleteCard(Card card);

}
