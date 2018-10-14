package com.services.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.models.Card;
import com.models.User;

public interface ICardBusinessService {
	public void create(int id,String title,String description,int health,int damage);
	public boolean delete();
	public void update(Card c);
	public ArrayList<Card> getAllCardsFromUser(int id);
	public Card getCard(Card c);
}
