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
   		System.out.println("INJECTING CARD DAO~!");
   		
		this.cardDAO = cardDAO;
	}

	@Override
	public Deck getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		
		int rowsDeleted = jdbcTemplateObject.update("delete carddb.decks where id = ?", id);
		if (rowsDeleted > 0) return true;
		
		return false;
	}

	@Override
	public boolean updateByModelById(Deck input, int id) {
		  jdbcTemplateObject.update("UPDATE carddb.decks userId = ?, description = ?, title = ?",
	    			input.getUserId(),
	    			input.getDescription(), 
	    			input.getTitle()
		);
		return false;
	}

	@Override
	public void addModel(Deck model) {
	
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
		
		for (int i = 0; i < results.size(); i++) {
			results.get(i).setCards(cardDAO.findCardsByDeckId(results.get(i).getDeckId()));
		}
		
		return results;
	}

	@Override
	public List<Deck> findAll() {
		
		String sql = "SELECT * FROM carddb.decks";
		
		List<Deck> results = jdbcTemplateObject.query(sql, new DeckMapper());	
		
		for (Deck d : results) {
			d.setCards(cardDAO.findCardsByDeckId(d.getDeckId()));
			System.out.println(d);
		}
		
		return results;
		
	}

}
