package com.services.interfaces;

import java.util.List;

public interface GenDAO<Model> {
	
	
	List<Model> findAll();
	Model getByValue(String valueName, Object value);
	void deleteByValue(String valueName, Object value);
	void updateByModelById(String valueName, Object Value);
	void addModel(Model model);
	
	
}
