package com.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.models.Card;
import com.models.Deck;
import com.models.User;
import com.services.interfaces.IDeckBusinessService;

public class MockDeckBusinessService implements IDeckBusinessService {

	IDeckBusinessService service;
	private static Deck deck1 = new Deck();
	private static Deck deck2 = new Deck();
	private static ArrayList<Deck> decks = new ArrayList<Deck>();
	
	public MockDeckBusinessService() {
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
	public List<Deck> getAllDecksByUser(User user) {

		int size = decks.size();
		int count = 0;
		List<Deck> deckVal = new ArrayList<Deck>();
		for(int i=1; i<size;i++) {
			if(/**decks.get(i).getUserId() == user.getId()**/ true) {
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
	public void addCardToDeck(Card card, String deckTitle) {
		// TODO Auto-generated method stub
		
		for(Deck deck : decks) {
			if (deck.getTitle().equals(deckTitle)) {
				deck.addCard(new Card(4, card.getTitle(),card.getDescription(),card.getHealth(),card.getDamage()));
			}
		}
		
	}
	
	public List<Card> getCardsByDeckTitle(String title) {
		
		for (Deck deck : decks) {
			if (deck.getTitle().equals(title)) return deck.getCards();
		}
		
		return null;
	}
		
	@Override
	public Deck getDeckByUserId(int id) {
		// TODO Auto-generated method stub
		
		for (Deck deck : decks) {
			if (deck.getUserId() == id) return deck;
		}
		
		
		return decks.get(id);
	}

	@Override
	public boolean addDeck(Deck deck) {
		decks.add(deck);
		return true;
	}

	
	/**
	 * returns a deck given its specified id
	 * @param id
	 * @return
	 */
	@Override
	public Deck findDeckById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Deck> findAllDecksByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Deck> findAllDecksByUserId(int username) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Card> getAllCardsFromUser(User id) {
		// TODO Auto-generated method stub
		return null;
	}


}
