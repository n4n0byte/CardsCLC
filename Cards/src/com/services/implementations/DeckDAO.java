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
	
   	@Autowired
	public void setDataSource(DataSource dataSource) {
   		System.out.println("INJECTING DATA SOURCE");
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}

   	
   	@Autowired
	public void setCardDAO(CardDAOInterface cardDAO) {
   		System.out.println("INJECTING CARD DAO~!");
   		
		this.cardDAO = cardDAO;
	}

	@Override
	public Deck getById(int id) {			
		List<Deck> decks  = jdbcTemplateObject.query("select * from carddb.decks where id = ? limit 1", new Object[]{id}, new DeckMapper());
		if (decks.size() > 0) {
			decks.get(0).setCards(cardDAO.findCardsByDeckId(decks.get(0).getDeckId()));
			return decks.get(0);		
		}
		
		return null;
	}

	@Override
	public Deck getByTitle(String title) {			
		List<Deck> decks  = jdbcTemplateObject.query("select * from carddb.decks where title = ? limit 1", new Object[]{title}, new DeckMapper());
		if (decks.size() > 0) {
			decks.get(0).setCards(cardDAO.findCardsByDeckId(decks.get(0).getDeckId()));
			return decks.get(0);		
		}
		
		return null;
	}

	
	@Override
	public boolean deleteById(int id) {
		
		int rowsDeleted = jdbcTemplateObject.update("delete from carddb.decks where id = ?", id);
		if (rowsDeleted > 0) return true;
		
		return false;
	}
	
	@Override
	public boolean deleteByTitle(String title) {
		
		int rowsDeleted = jdbcTemplateObject.update("delete from carddb.decks where title = ?", title);
		if (rowsDeleted > 0) return true;
		
		return false;
		
	}

	@Override
	public boolean updateByModelById(Deck input, int id) {
		
		jdbcTemplateObject.update("UPDATE carddb.decks set description = ?, title = ? where userId = ?",
			input.getDescription(), 
			input.getTitle(),
			id
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
