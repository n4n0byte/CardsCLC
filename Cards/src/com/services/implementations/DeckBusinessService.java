package com.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.models.Card;
import com.models.Deck;
import com.models.User;
import com.services.interfaces.IDeckBusinessService;

public class DeckBusinessService implements IDeckBusinessService {

	IDeckBusinessService service;
	private static ArrayList<Card> deck = new ArrayList<Card>();
	private static ArrayList<Card> deck2 = new ArrayList<Card>();
	private static ArrayList<Deck> decks = new ArrayList<Deck>();
	private static ArrayList<Card> cards = new ArrayList<Card>();
	
	public DeckBusinessService() {
		cards.add(new Card(1,"Monster1","description",10,10));
		cards.add(new Card(2,"Monster2","description",10,10));
		cards.add(new Card(3,"Monster3","description",10,10));
		
		deck.add(new Card(3,"Monster1","description",10,10));
		deck.add(new Card(3,"Monster2","description",10,10));
		deck.add(new Card(3,"Monster3","description",10,10));
		
		deck2.add(new Card(3,"Monster1","description",10,10));
		deck2.add(new Card(3,"Monster2","description",10,10));
		deck2.add(new Card(3,"Monster3","description",10,10));
		
		decks.add(deck);
		decks.add(deck2);
		
	}
	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	public void update(Deck d, int num) {
		// TODO Auto-generated method stub
		int id = d.getId();
		String title = d.getTitle();
		String descript = d.getDescription();
		
		decks.get(num).setDescription(descript);
		decks.get(num).setTitle(title);
	}

	public ArrayList<Deck> getAllDecksFromUser(int id) {
		// Auto-generated method stub TODO
		int size = decks.size();
		int count = 0;
		ArrayList<Deck> deckVal = new ArrayList<Deck>();
		for(int i=1; i<size;i++) {
			if(decks.get(i).getId()==id) {
				deckVal.add(decks.get(i));
				count++;
			}		
		}
		if(count==0) {
			return null;
		}
		return deckVal;

	}

	public ArrayList<Card> getCardsByDeckTitle(String title) {
		// TODO Auto-generated method stub
		
		for(int i=1;i<deck.size();i++){
			cards.add(deck.get(i));
		}
		return cards;
	}

	@Override
	public Deck getDeckByUserId(int id) {
		// TODO Auto-generated method stub
		
		return decks.get(id);
	}

}
