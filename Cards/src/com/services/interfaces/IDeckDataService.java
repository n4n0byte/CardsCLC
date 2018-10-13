package com.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.models.Deck;

public interface IDeckDataService {
	public void addDeckToCollectionById(Deck deck, int collectionId);
	public Optional<Deck> findDeckById(int id);
	public Optional<List<Deck>> findAllDecksByUsername(String username);
	public Optional<List<Deck>> findAllDecksByUserId(int username);
	public void updateDeck(Deck deck);
	public Boolean deleteDeckById(int id);
	public Boolean deleteDeck(Deck card);
	
}
