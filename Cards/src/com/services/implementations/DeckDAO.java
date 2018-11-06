package com.services.implementations;


import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.mappers.DeckMapper;
import com.models.Deck;
import com.services.interfaces.CardDAOInterface;
import com.services.interfaces.DeckDAOInterface;

/**
 * 
 * @author Ali Cooper
 *	Data Access Object used for crud operations
 *	on Deck objects
 *
 */
public class DeckDAO implements DeckDAOInterface {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private CardDAOInterface cardDAO;
	/**
	 * Creates connection to database
	 * @param dataSource
	 */
   	@Autowired
	public void setDataSource(DataSource dataSource) {
   		System.out.println("INJECTING DATA SOURCE");
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}

   	/**
   	 * sets the implementation of the CardDOA
   	 * @param cardDAO
   	 */
   	@Autowired
	public void setCardDAO(CardDAOInterface cardDAO) {
   		System.out.println("INJECTING CARD DAO~!");
   		
		this.cardDAO = cardDAO;
	}
   	
   	/**
   	 * Returns a Decks by its deck id
   	 */
	@Override
	public Deck getById(int id) {			
		List<Deck> decks  = jdbcTemplateObject.query("select * from carddb.decks where id = ? limit 1", new Object[]{id}, new DeckMapper());
		if (decks.size() > 0) {
			decks.get(0).setCards(cardDAO.findCardsByDeckId(decks.get(0).getDeckId()));
			return decks.get(0);		
		}
		
		return null;
	}
	
	/**
	 * Returns a Deck by its title
	 */
	@Override
	public Deck getByTitle(String title) {			
		List<Deck> decks  = jdbcTemplateObject.query("select * from carddb.decks where title = ? limit 1", new Object[]{title}, new DeckMapper());
		if (decks.size() > 0) {
			decks.get(0).setCards(cardDAO.findCardsByDeckId(decks.get(0).getDeckId()));
			return decks.get(0);		
		}
		
		return null;
	}

	/**
	 * Delete operation of CRUD for deck
	 * deletes a deck by its deck id
	 */
	@Override
	public boolean deleteById(int id) {
		
		int rowsDeleted = jdbcTemplateObject.update("delete from carddb.decks where id = ?", id);
		if (rowsDeleted > 0) return true;
		
		return false;
	}
	
	/**
	 * Delete operation of CRUD for deck
	 * Deletes a deck by its deck title
	 */
	@Override
	public boolean deleteByTitle(String title) {
		
		int rowsDeleted = jdbcTemplateObject.update("delete from carddb.decks where title = ?", title);
		if (rowsDeleted > 0) return true;
		
		return false;
		
	}

	/**
	 * update operation of CRUD for deck
	 * updates ad deck based on that decks id
	 */
	@Override
	public boolean updateByModelById(Deck input, int id) {
		
		jdbcTemplateObject.update("UPDATE carddb.decks set description = ?, title = ? where userId = ?",
			input.getDescription(), 
			input.getTitle(),
			id
		);
		return false;
	}

	/**
	 * Create operation of CRUD for deck
	 * Creates a deck in the database
	 */
	@Override
	public void addModel(Deck model) {
	
	    jdbcTemplateObject.update("INSERT INTO carddb.decks (userId, description, title) VALUES (?, ?, ?)",
	    			model.getUserId(),
	    			model.getDescription(), 
	    			model.getTitle()
		);
	    		
	}
	
	/**
	 * Returns a list of decks made by the same user
	 */
	@Override
	public List<Deck> findAllDecksByUserId(int id) {
		
		String sql = "SELECT id, userId, description, title FROM carddb.decks where userId = " + id;
		List<Deck> results = jdbcTemplateObject.query(sql, new DeckMapper());
		
		for (int i = 0; i < results.size(); i++) {
			results.get(i).setCards(cardDAO.findCardsByDeckId(results.get(i).getDeckId()));
		}
		
		return results;
	}

	/**
	 * 
	 */
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
