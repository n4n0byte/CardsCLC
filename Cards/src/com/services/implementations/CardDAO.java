package com.services.implementations;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.exceptions.DAOException;
import com.mappers.CardMapper;
import com.models.Card;
import com.models.Deck;
import com.services.interfaces.GenericDAOInterface;

public class CardDAO implements GenericDAOInterface<Card>{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		System.out.println("INJECTING DATA SOURCE FROM CARD");
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}

	@Override
	public List<Card> findAll() {
		String sql = "SELECT * FROM carddb.cards";

		List<Card> results = null;

		try {
			results  = jdbcTemplateObject.query(sql, new CardMapper());
			
		} catch(DataAccessException e) {
			throw new DAOException(e.getMessage(), e);
		}catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		for( Card c : results) {
			System.out.println(c);
		}

		return results;
	}

	@Override
	public Card getById(int id) {

		String sql = "SELECT * FROM carddb.cards where id = ?";

		Card results = null;

		try {
			results  = jdbcTemplateObject.queryForObject(sql, new Object[] {id}, new CardMapper());
		} catch(DataAccessException e) {
			throw new DAOException(e.getMessage()+"\n"+e.getStackTrace(), e);
		}catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		return results;
	}

	@Override
	public void addModel(Card model) {

		try {
			jdbcTemplateObject.update("INSERT INTO carddb.cards (deckId, title, description, health, damage) VALUES (?, ?, ?, ?, ?)",
				model.getDeckId(),
				model.getTitle(),
				model.getDescription(),
				model.getHealth(),
				model.getDamage()
			);
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage()+"\n"+e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
	}

	public List<Card> findAllByModelId(int id) {
		String sql = "SELECT * FROM carddb.cards where deckId = " + id;

		List<Card> results = null;

		try {
			results = jdbcTemplateObject.query(sql, new CardMapper());
		}catch (DataAccessException e) {
			throw new DAOException(e.getMessage()+"\n"+e.getStackTrace(), e);
		}catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		return results;
	}

	
	@Override
	public boolean deleteById(int id) {
		// TODO stub for next milestone's functionality
		return false;
	}

	@Override
	public boolean updateByModelById(Card input, int id) {
		// TODO stub for next milestone functionality
		return false;
	}

	@Override
	public Card findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateByModelName(Card input, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addCardToModelWithModelName(Card input, String name) {
		// TODO Auto-generated method stub
		
	}


}
