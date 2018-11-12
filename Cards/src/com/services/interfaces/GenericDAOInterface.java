package com.services.interfaces;

import java.util.List;

import com.models.Card;
/**
 * 
 * @author Anthony Natividad
 * Generic interface for all DAO objects
 * @param <Model>
 */
public interface GenericDAOInterface<Model> {
	
	List<Model> findAll();
	Model getById(int id);
	List<Model> findAllByModelId(int id);
	Model findByName(String name);
	void addModel(Model model);
	boolean updateByModelById(Model input, int id);
	boolean updateByModelName(Model input, String name);
	boolean deleteById(int id);
	boolean deleteByName(String name);
	void addCardToModelWithModelName(Card input, String name);
}
