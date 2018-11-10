package com.services.implementations;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.exceptions.DAOException;
import com.mappers.UserMapper;
import com.models.User;
import com.services.interfaces.UserDAOInterface;

public class UserDAO implements UserDAOInterface {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * from users";

		List<User> results = null;
		try {
			results = jdbcTemplateObject.query(sql, new UserMapper());
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
		return results;
	}

	@Override
	public User getById(int id) {
		
		String sql = "SELECT * from users where id = ?";
		
		List<User> results = null;

		try {
			results = jdbcTemplateObject.query(sql, new Object[] { id }, new UserMapper());
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

		if (results.size() > 0)
			return results.get(0);
		
		throw new DAOException("not found", new Exception());
	}

	@Override
	public boolean deleteById(int id) {
		return false;
	}

	@Override
	public boolean updateByModelById(User input, int id) {
		return false;
	}

	@Override
	public void addModel(User model) {

		try {
			jdbcTemplateObject.update(
					"INSERT INTO carddb.users (email, firstName, lastName, password, username) "
							+ "VALUES (?, ?, ?, ?, ?)",
					model.getEmail(), model.getFirstName(), model.getLastName(), model.getPassword(),
					model.getUsername());
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}

	}

	@Override
	public User findByUsername(String username) {
		String sql = "SELECT * from carddb.users where username = ?";
		List<User> results = null;
		try {
			results = jdbcTemplateObject.query(sql, new Object[] { username }, new UserMapper());
		} catch (DataAccessException e) {
			throw new DAOException(e.getMessage() + "\n" + e.getStackTrace(), e);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
		if (results.size() > 0)
			return results.get(0);
		return null;
	}

}
