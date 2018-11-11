package com.services.implementations;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.exceptions.DAOException;
import com.mappers.DeckMapper;
import com.models.Card;
import com.models.Deck;
import com.services.interfaces.GenericDAOInterface;

/**
 * 
 * @author Ali Cooper Data Access Object used for crud operations on Deck
 *         objects
 *
 */
public class DeckDAO implements GenericDAOInterface<Deck> {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private GenericDAOInterface<Card> cardDAO;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		System.out.println("INJECTING DATA SOURCE");
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}

	@Autowired
	public void setCardDAO(GenericDAOInterface<Card> cardDAO) {
		System.out.println("INJECTING CARD DAO~!");

		this.cardDAO = cardDAO;
	}

	@Override
	public Deck getById(int id) {
		List<Deck> decks = null;

		try {
			decks = jdbcTemplateObject.query("select * from carddb.decks where id = ? limit 1", new Object[] { id },
					new DeckMapper());
			if (decks.size() > 0) {
				decks.get(0).setCards(cardDAO.findAllByModelId(decks.get(0).getDeckId()));
				return decks.get(0);
			}
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		return null;
	}

	@Override
	public Deck findByName(String title) {
		List<Deck> decks = jdbcTemplateObject.query("select * from carddb.decks where title = ? limit 1",
				new Object[] { title }, new DeckMapper());
		if (decks.size() > 0) {
			decks.get(0).setCards(cardDAO.findAllByModelId(decks.get(0).getDeckId()));
			return decks.get(0);
		}

		return null;
	}

	@Override
	public boolean deleteById(int id) {

		try {
			int rowsDeleted = jdbcTemplateObject.update("delete from carddb.decks where id = ?", id);
			if (rowsDeleted > 0)
				return true;
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		return false;
	}

	@Override
	public boolean deleteByName(String title) {

		try {
			int rowsDeleted = jdbcTemplateObject.update("delete from carddb.decks where title = ?", title);
			if (rowsDeleted > 0)
				return true;
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		return false;

	}

	@Override
	public boolean updateByModelById(Deck input, int id) {

		try {
			int rows = jdbcTemplateObject.update("UPDATE carddb.decks set description = ?, title = ? where userId = ?",
					input.getDescription(), input.getTitle(), id);

			if (rows == 1)
				return true;
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		return false;
	}

	@Override
	public void addModel(Deck model) {

		try {
			jdbcTemplateObject.update("INSERT INTO carddb.decks (userId, description, title) VALUES (?, ?, ?)",
					model.getUserId(), model.getDescription(), model.getTitle());

		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

	}

	public List<Deck> findAllByModelId(int id) {

		String sql = "SELECT id, userId, description, title FROM carddb.decks where userId = " + id;
		List<Deck> results = null;

		try {
			results = jdbcTemplateObject.query(sql, new DeckMapper());
			for (int i = 0; i < results.size(); i++) {
				results.get(i).setCards(cardDAO.findAllByModelId(results.get(i).getDeckId()));
			}
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
		return results;
	}

	@Override
	public List<Deck> findAll() {

		String sql = "SELECT * FROM carddb.decks";

		List<Deck> results = null;
		try {
			results = jdbcTemplateObject.query(sql, new DeckMapper());

			for (Deck d : results) {
				d.setCards(cardDAO.findAllByModelId(d.getDeckId()));
			}

		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
		return results;

	}


	@Override
	public boolean updateByModelName(Deck input, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addCardToModelWithModelName(Card model, String name) {
		try {
//			jdbcTemplateObject.update("INSERT INTO carddb.cards (deckId,title,description,health,damage) VALUES (?,?,?,?,?)",name+"WHERE deckId=);

		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
		
	}

}
