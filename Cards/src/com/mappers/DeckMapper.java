package com.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.models.Card;
import com.models.Deck;

public class DeckMapper implements RowMapper<Deck>{

	@Override
	public Deck mapRow(ResultSet arg0, int arg1) throws SQLException {
		Deck deck = new Deck();
		deck.setTitle(arg0.getString("title"));
		deck.setDescription(arg0.getString("description"));
		deck.setUserId(arg0.getInt("userId"));
		return deck;
	}
	
}
