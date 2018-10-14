package com.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.models.Card;
import com.models.User;
import com.services.interfaces.ICardBusinessService;

public class CardBusinessService implements ICardBusinessService {

	private static ArrayList<Card> cards = new ArrayList<Card>();
	
	public CardBusinessService() {
		cards.add(new Card(1,"Monster1","description",10,10));
		cards.add(new Card(2,"Monster2","description",10,10));
		cards.add(new Card(3,"Monster3","description",10,10));
	}
	
	@Override
	public void create(int id, String title, String description, int health, int damage) {
		// TODO Auto-generated method stub
		cards.add(new Card(4, title,description,health,damage));

	}

	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	public void update(Card c) {
		// TODO Auto-generated method stub
		int damage=c.getDamage();
		String desc=c.getDescription();
		int health=c.getHealth();
		int id=c.getId();
		String title=c.getTitle();
		for(int i=0;i<cards.size();i++) {
			if(cards.get(i).getId()==id) {
				cards.get(i).setDamage(damage);
				cards.get(i).setDescription(desc);
				cards.get(i).setTitle(title);
				cards.get(i).setHealth(health);
			}
		}

	}

	@Override
	public ArrayList<Card> getAllCardsFromUser(User id) {
		// TODO Auto-generated method stub
		ArrayList<Card> cardVal = new ArrayList<Card>();
		int index =id.getId();
		for(int i=0;i<cards.size();i++) {
			if(cards.get(i).getId()==index) {
				cardVal.add(cards.get(i));
			}
		}
		return cardVal;
	}

	@Override
	public Card getCard(Card c) {
		// TODO Auto-generated method stub
		String name= c.getTitle();
		for(int i=0;i<cards.size();i++) {
			if(cards.get(i).getTitle()==name) {
				return cards.get(i);
			}
			
		}
		return null;
		
	}

}
