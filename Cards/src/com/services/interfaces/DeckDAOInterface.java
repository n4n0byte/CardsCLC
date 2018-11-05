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
public interface DeckDAOInterface extends GenericDAOInterface<Deck>{
	
	public List<Deck> findAllDecksByUserId(int id);
	public boolean addCardToDeckWithDeckId(Card card, int deckId);

}