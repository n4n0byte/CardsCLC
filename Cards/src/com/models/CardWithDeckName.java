package com.models;

public class CardWithDeckName {
	Card card;
	String name;
	
	public CardWithDeckName() {
		card = new Card();
		name = "";
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	
	
}
