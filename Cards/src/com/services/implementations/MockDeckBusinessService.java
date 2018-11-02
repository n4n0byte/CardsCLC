package com.services.implementations;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.models.Card;
import com.models.Deck;
import com.models.User;
import com.services.interfaces.IDeckBusinessService;
import com.services.interfaces.IDeckDataService;

public class MockDeckBusinessService implements IDeckBusinessService {
	
	IDeckDataService iDeckDataService;
	/*sets the iDeckDataService*/
	@Autowired
	public void setiDeckDataService(IDeckDataService iDeckDataService) {
		this.iDeckDataService = iDeckDataService;
	}
	/**
	 *	
	 */
	@Override
	public void addCardToDeck(Card card, String deckTitle) {
		
		iDeckDataService.addCardToDeckWithDeckTitle(card, deckTitle);
		
		
	}
			
	@Override
	public List<Deck> getDeckByUserId(int id) {
		
		return iDeckDataService.findAllDecksByUserId(id);
		
	}

	@Override
	public boolean addDeck(Deck deck) {		
		return iDeckDataService.addDeck(deck);
	}

	
	/**
	 * returns a deck given its specified id
	 * @param id
	 * @return
	 */
	@Override
	public Deck findDeckByDeckId(int id) {
		return iDeckDataService.findDeckById(id);
	}

	@Override
	public List<Deck> findAllDecksByUsername(String username) {
		return iDeckDataService.findAllDecksByUsername(username);
	}

	@Override
	public List<Deck> findAllDecksByUserId(int id) {
		return iDeckDataService.findAllDecksByUserId(id);
	}
	
	

	@Override
	public void updateDeck(Deck deck) {
		iDeckDataService.updateDeck(deck);
	}

	@Override
	public boolean deleteDeckById(int id) {
		return iDeckDataService.deleteDeckById(id);
	}

	@Override
	public boolean deleteDeck(Deck deck) {
		return iDeckDataService.deleteDeck(deck);
	}

	@Override
	public boolean addCardToDeckWithDeckId(Card card, int deckId) {
		return iDeckDataService.addCardToDeckWithDeckId(card, deckId);		
	}

	@Override
	public List<Card> getAllCardsFromUser(User user) {
		return iDeckDataService.findCardsByUserId(user.getId());
	}


}
