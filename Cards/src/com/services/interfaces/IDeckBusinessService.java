package com.services.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.models.Card;
import com.models.Deck;
import com.models.User;

public interface IDeckBusinessService {
	
	public boolean delete();
	public void update(Deck d);
	public ArrayList<Deck> getAllDecksFromUser(User id);
	public ArrayList<Card> getCardsByDeckTitle(String title);	
	public Deck getDeckByUserId(int id);
}
