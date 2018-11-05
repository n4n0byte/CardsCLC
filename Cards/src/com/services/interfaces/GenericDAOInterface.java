package com.services.interfaces;

import java.util.Optional;

public interface GenericDAOInterface<Model> {
	
	Optional<Model> getById(int id);
	boolean deleteById(int id);
	boolean updateByModel(Model model);
	boolean addModel(Model model);
	
}
