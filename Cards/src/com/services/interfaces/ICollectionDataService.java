package com.services.interfaces;

import java.util.Optional;

import com.models.Collection;

public interface ICollectionDataService {
	
	
	public Optional<Collection> findCollectionById(int id);
	public Optional<Collection> findCollectionByUsernme(String username);
	public void updateCollection(Collection collection);
	public Boolean deleteCollection(Collection collection);	
	public Boolean deleteCollectionById(int id);

}
