package com.services.interfaces;

import java.util.List;

import com.models.Deck;

/**
 *
 * @author Ali Cooper, Anthony Natvidad
 *
 */
public interface DeckDAOInterface extends GenericDAOInterface<Deck>{
	
	public List<Deck> findAllDecksByUserId(int id);
	public boolean deleteByTitle(String title);
	Deck getByTitle(String title);

}