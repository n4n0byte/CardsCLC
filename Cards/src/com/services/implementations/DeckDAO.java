package com.services.implementations;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mappers.DeckMapper;
import com.models.Card;
import com.models.Deck;
import com.services.interfaces.CardDAOInterface;
import com.services.interfaces.DeckDAOInterface;

public class DeckDAO implements DeckDAOInterface {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private CardDAOInterface cardDAO;
	
   	@Autowired
	public void setDataSource(DataSource dataSource) {
   		System.out.println("INJECTING DATA SOURCE");
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource);
	}

   	
   	@Autowired
	public void setCardDAO(CardDAOInterface cardDAO) {
		this.cardDAO = cardDAO;
	}

	@Override
	public Deck getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateByModelById(Deck input, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addModel(Deck model) {
		System.out.println("ADDING DECK");
	
	    jdbcTemplateObject.update("INSERT INTO carddb.decks (userId, description, title) VALUES (?, ?, ?)",
	    			model.getUserId(),
	    			model.getDescription(), 
	    			model.getTitle()
		);
	    		
	}


	@Override
	public boolean addCardToDeckWithDeckId(Card card, int deckId) {
		 jdbcTemplateObject.update("INSERT INTO carddb.cards (deckId, title, description, health, damage) VALUES (?, ?, ?, ?, ?)",
	    		deckId,
	    		card.getTitle(),
	    		card.getDescription(),
	    		card.getHealth(),
	    		card.getDamage()
		);
		return false;
	}


	@Override
	public List<Deck> findAllDecksByUserId(int id) {
		
		String sql = "SELECT id, userId, description, title FROM carddb.decks where userId = " + id;
				
		List<Deck> results = jdbcTemplateObject.query(sql, new DeckMapper());
		
		for (Deck deck : results) {
			
		}
		
		return results;
	}

	@Override
	public List<Deck> findAll() {
		
		String sql = "SELECT * FROM carddb.decks";
		
		List<Deck> res = jdbcTemplateObject.query(sql, new DeckMapper());	
		
		for (Deck d : res) {
			System.out.println(d);
		}
		
		return res;
		
	}

}
