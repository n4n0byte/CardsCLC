package com.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.models.Card;
import com.models.Collection;
import com.models.Deck;

/**
 * 
 * @author Ali Cooper
 * specifies methods for 
 *
 */
public interface ICardDataService {
	
	public void addCard(Card card);
	public void addCardToDeckByDeckId(Card card, int deckId);
	public void addDeckToCollectionById(Deck deck, int collectionId);
	
	public Optional<Card> findCardById(int id);
	public Optional<Card> findCardByTitle(String title);
	public Optional<Deck> findDeckById(int id);
	public Optional<List<Deck>> findAllDecksByUsername(String username);
	public Optional<List<Deck>> findAllDecksByUserId(int username);
	public Optional<Collection> findCollectionById(int id);
	public Optional<Collection> findCollectionByUsernme(String username);
	
	public void updateCard(Card card);
	public void updateDeck(Deck deck);
	public void updateCollection(Collection collection);
	
	public Boolean deleteCardById(int id);
	public Boolean deleteCard(Card card);
	public Boolean deleteCollection(Collection collection);
	
	public Boolean deleteDeckById(int id);
	public Boolean deleteDeck(Deck card);
	public Boolean deleteCollectionById(int id);

}
