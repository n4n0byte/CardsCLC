package com.services.implementations;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mappers.CardMapper;
import com.models.Card;
import com.services.interfaces.CardDAOInterface;
/**
 * 
 * @author Ali Cooper & Anthony Natividad
 * Card Data Access Object that handles the CRUD operations of Card
 */
public class CardDAO implements CardDAOInterface{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	/**
	 * Creates connection to database
	 * @param dataSource
	 */
   	@Autowired
	public void setDataSource(DataSource dataSource) {
   		System.out.println("INJECTING DATA SOURCE FROM CARD");
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}
	/**
	 * Returns a list of all cards in the database
	 */
	@Override
	public List<Card> findAll() {
		String sql = "SELECT * FROM carddb.cards";
		
		List<Card> results = jdbcTemplateObject.query(sql, new CardMapper());
		
		for( Card c : results) {
			System.out.println(c);
		}

		return results;
	}
	/**
	 * Returns a list of cards that are made from a specific user
	 */
	@Override
	public Card getById(int id) {
		
		String sql = "SELECT * FROM carddb.cards where id = ?";
		
		Card results = jdbcTemplateObject.queryForObject(sql, new Object[] {id}, new CardMapper());
		
		return results;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateByModelById(Card input, int id) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Create operation of Card
	 * takes a card model and passes variables into a SQL statement
	 * SQL statement executes update and adds card to database
	 */
	@Override
	public void addModel(Card model) {
		jdbcTemplateObject.update("INSERT INTO carddb.cards (deckId, title, description, health, damage) VALUES (?, ?, ?, ?, ?)",
	    		model.getDeckId(),
	    		model.getTitle(),
	    		model.getDescription(),
	    		model.getHealth(),
	    		model.getDamage()
		);
	}
	/**
	 * This method is a Read operation for the CRUD of card
	 * this will return all cards that are in a specific deck using the decks id
	 */
	@Override
	public List<Card> findCardsByDeckId(int deckId) {
		String sql = "SELECT * FROM carddb.cards where deckId = " + deckId;
		
		List<Card> results = jdbcTemplateObject.query(sql, new CardMapper());
		
		for( Card c : results) {
			System.out.println(c);
		}
		
		return results;
	}


}
