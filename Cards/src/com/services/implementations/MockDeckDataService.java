package com.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.models.Card;
import com.models.Deck;
import com.services.interfaces.DeckDAOInterface;

public class MockDeckDataService implements DeckDAOInterface{

	DeckDAOInterface service;
	
	
	@Autowired
	public void setService(DeckDAOInterface service) {
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
	public boolean addCardToDeckWithDeckId(Card card, int deckId) {
		for (Deck deck : decks) {
			if (deck.getDeckId() == deckId) deck.addCard(card);
		}
		return false;
	}




	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void addModel(Deck model) {
		decks.add(model);
	}


	@Override
	public boolean updateByModelById(Deck input, int id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Deck> findAllDecksByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Deck> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Deck getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
