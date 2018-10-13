package com.models;

public class Card {
	private String name;
	private String effect;
	private String level;
	private String attack;
	private String defense;
	private String id;
	
	public Card() {
		
	}

	public Card(String name, String effect, String level, String attack, String defense, String id) {
		super();
		this.name = name;
		this.effect = effect;
		this.level = level;
		this.attack = attack;
		this.defense = defense;
		this.id = id;
	}
	
}
