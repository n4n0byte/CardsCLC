package com.services.interfaces;

import java.util.ArrayList;

import com.models.Card;

public interface IDeckBusinessService {
	static ArrayList<Card> deck = new ArrayList<Card>();
	
	public void create();
	public void delete();
	public void update();
	public void getDeck(int id);
	public void getDeck(String name);
}
