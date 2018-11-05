package com.services.implementations;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mappers.CardMapper;
import com.models.Card;
import com.services.interfaces.CardDAOInterface;

public class CardDAO implements CardDAOInterface{

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
		
		List<Card> results = jdbcTemplateObject.query(sql, new CardMapper());
		
		for( Card c : results) {
			System.out.println(c);
		}

		return results;
	}

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

	@Override
	public void addModel(Card model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Card> findCardsByDeckId(int deckId) {
		String sql = "SELECT * FROM carddb.cards where deckId = " + deckId;
		
		List<Card> results = jdbcTemplateObject.query(sql, new CardMapper());
		
		for( Card c : results) {
			System.out.println(c);
		}
		
		return results;
	}

	@Override
	public Card findCardById(int id) {
		return null;
	}


}
