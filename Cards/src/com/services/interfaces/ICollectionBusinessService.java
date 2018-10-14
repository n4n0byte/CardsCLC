package com.services.interfaces;

import java.util.ArrayList;

import com.models.Card;
import com.models.Deck;

public interface ICollectionBusinessService {
	
	private ArrayList<Card> getCards();
	private ArrayList<Deck> getDecks();
}
