package com.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.models.Card;
import com.models.Deck;
import com.services.interfaces.ICollectionBusinessService;

public class CollectionBusinessService implements ICollectionBusinessService {
	
	private static ArrayList<Card> deck = new ArrayList<Card>();
	private static ArrayList<Card> deck2 = new ArrayList<Card>();
	private static ArrayList<Deck> decks = new ArrayList<Deck>();
	private static ArrayList<Card> cards;
	
	public CollectionBusinessService() {
		cards.add(new Card(1,"Monster1","description",10,10));
		cards.add(new Card(2,"Monster2","description",10,10));
		cards.add(new Card(3,"Monster3","description",10,10));
		
		deck.add(new Card(3,"Monster1","description",10,10));
		deck.add(new Card(3,"Monster2","description",10,10));
		deck.add(new Card(3,"Monster3","description",10,10));
		
		ArrayList<Card> deck2 = new ArrayList<Card>();
		deck2.add(new Card(3,"Monster1","description",10,10));
		deck2.add(new Card(3,"Monster2","description",10,10));
		deck2.add(new Card(3,"Monster3","description",10,10));
		
		decks.add(deck);
		decks.add(deck2);
	}
	
	public ArrayList<Deck> getDecks(){
		return decks;
	}
	public ArrayList<Card> getCards(){
		return cards;
	}
}
