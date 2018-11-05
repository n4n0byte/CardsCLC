package com.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.models.Card;
import com.models.Deck;
import com.services.interfaces.DeckDataServiceInterface;

public class MockDeckDataService implements DeckDataServiceInterface{

	DeckDataServiceInterface service;
	
	
	@Autowired
	public void setService(DeckDataServiceInterface service) {
		this.service = service;
	}

	private static Deck deck1 = new Deck();
	private static Deck deck2 = new Deck();
	private static ArrayList<Deck> decks = new ArrayList<Deck>();

	public MockDeckDataService() {
		// TODO Auto-generated constructor stub
		System.out.println("IN MOCK DECK SVC CONSTRUCTOR");
		deck1.setTitle("Deck 1");
		deck1.setDescription("Deck Description");
		deck1.addCard(new Card(1,"Monster1Deck1","description",10,10));
		deck1.addCard(new Card(2,"Monster2Deck1","description",10,10));
		deck1.addCard(new Card(3,"Monster3Deck1","description",10,10));
		
		deck2.setTitle("Deck 2");
		deck2.setDescription("Deck Description");
		deck2.addCard(new Card(3,"Monster1Deck2","description",10,10));
		deck2.addCard(new Card(3,"Monster2Deck2","description",10,10));
		deck2.addCard(new Card(3,"Monster3Deck2","description",10,10));
				
		decks.add(deck1);
		decks.add(deck2);
		
	}

	
	@Override
	public Deck findDeckById(int id) {
		
		for (Deck deck : decks) {
			if (deck.getDeckId() == id) return deck;
		}
		return null;
	}

	@Override
	public List<Deck> findAllDecksByUsername(String username) {
		return decks;
	}

	@Override
	public List<Deck> findAllDecksByUserId(int userId) {
		int size = decks.size();
		int count = 0;
		List<Deck> deckVal = new ArrayList<Deck>();
		for(int i=1; i<size;i++) {
			if(true) {
				deckVal.add(decks.get(i));
				count++;
			}		
		}
		if(count==0) {
			return null;
		}
		return deckVal;
	}

	@Override
	public void updateDeck(Deck deck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteDeckById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDeck(Deck card) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCardToDeckWithDeckId(Card card, int deckId) {
		for (Deck deck : decks) {
			if (deck.getDeckId() == deckId) deck.addCard(card);
		}
		return false;
	}

	@Override
	public Card findCardById(int id) {
		for(Deck deck : decks) {
			for(Card card : deck.getCards()) {
				if (card.getId() == id) return card;
			}
		}
		return null;
	}


	@Override
	public Card findCardByTitle(String title) {
		for(Deck deck : decks) {
			for(Card card : deck.getCards()) {
				if (card.getTitle().equals(title)) return card;
			}
		}
		return null;
	}


	@Override
	public boolean addCardToDeckWithDeckTitle(Card card, String deckTitle) {
		for(Deck deck : decks) {
			if (deck.getTitle().equals(deckTitle)) {
				deck.addCard(new Card(4, card.getTitle(),card.getDescription(),card.getHealth(),card.getDamage()));
			}
		}		
		return true;
	}


	@Override
	public boolean addDeck(Deck deck) {
		decks.add(deck);
		return true;
	}

	@Override
	public List<Card> findCardsByUserId(int userId) {
		List<Card> cards = new ArrayList<>();
		for(Deck deck : decks) {
			if (deck.getUserId() == userId) {
				cards.addAll(deck.getCards());
			}
		}		
		return cards;
	}

	
	
}
