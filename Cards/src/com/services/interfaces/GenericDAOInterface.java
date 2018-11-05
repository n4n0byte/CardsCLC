package com.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.models.User;

public interface GenericDAOInterface<Model> {
	
	List<Model> findAll();
	Model getById(int id);
	boolean deleteById(int id);
	boolean updateByModelById(Model input, int id);
	void addModel(Model model);
	
}
