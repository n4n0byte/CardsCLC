package com.models;

public class CardDeckComposite {
	Card card;
	Deck deck;
	
	public CardDeckComposite() {
		card = new Card();
		deck = new Deck();
	}
	
	
	public void setCard(Card card) {
		this.card = card;
	}



	public void setDeck(Deck deck) {
		this.deck = deck;
	}



	Deck getDeck() {
		return deck;
	}
	
	Card getCard() {
		return card;
	}
}
