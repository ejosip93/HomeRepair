package hr.java.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import hr.java.dao.UserDao;
import hr.java.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	private final String USER_QUERY = "SELECT USERNAME, PASSWORD, EMAIL FROM USERS";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void addUser(User u) {
		logger.info("Dodan je user: " + u.getUsername() + ", email: " + u.getEmail());
		jdbcTemplate.update("INSERT INTO USERS (username, email, password) VALUES( ?, ?, ?)", u.getUsername(), u.getEmail(), u.getPassword());
		
	}

	@Override
	public List<User> getUsers() {
		return jdbcTemplate.query(USER_QUERY, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3));
			}});
		
	}

	@Override
	public User getUserByUsername(String name) {
		return (User) jdbcTemplate.queryForObject("SELECT USERNAME, PASSWORD, EMAIL FROM USERS WHERE USERNAME = ?", new Object[]{name}, new BeanPropertyRowMapper<>(User.class));

		
	}

}
