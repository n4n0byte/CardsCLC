package com.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author Ali Cooper
 *
 */
public class Deck {
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String title;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String description;
	List<Card> cards;
	int id;
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addCard(Card card) {
		if(cards == null) cards = new ArrayList<>();
		cards.add(card);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
	
	
	
	
}
