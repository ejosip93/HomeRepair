package hr.java.fpz.dao.impl;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import hr.java.fpz.dao.UserDao;
import hr.java.fpz.model.User;
import hr.java.fpz.model.UserDetails;

@Repository
public class UserDaoImpl implements UserDao{

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	private final String USER_QUERY = "SELECT USERNAME, PASSWORD, EMAIL, USERS_ROLES.ID_ROLE AS USERTYPE FROM USERS JOIN USERS_ROLES ON USERS.ID = USERS_ROLES.ID_ROLE";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void addUser(User u) {
		byte[] slika = null;
		try {
			slika = u.getPicture().getBytes();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		logger.info("Dodan je user: " + u.getUsername() + ", email: " + u.getEmail());
		jdbcTemplate.update("INSERT INTO USERS (username, email, password, picture) VALUES( ?, ?, ?, ?)", u.getUsername(), u.getEmail(), u.getPassword(), slika);
		jdbcTemplate.update("INSERT INTO USERS_ROLES VALUES(?, ?)",getUserId(u.getUsername()) ,u.getUserType());
		try {
			u.getPicture().transferTo(new File("G:\\eclipse\\slike\\" + u.getUsername() + ".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}

	@Override
	public List<User> getUsers() {
		return jdbcTemplate.query(USER_QUERY, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}});
		
	}

	private Integer getUserId(String name){
		return jdbcTemplate.queryForObject("SELECT ID FROM USERS WHERE USERNAME = ?", new Object[]{name}, Integer.class);
	}
	
	@Override
	public User getUserByUsername(String name) {
		return (User) jdbcTemplate.queryForObject("SELECT ID, USERNAME, PASSWORD, EMAIL, USERS_ROLES.ID_ROLE AS USERTYPE FROM USERS JOIN USERS_ROLES ON USERS.ID = USERS_ROLES.ID_ROLE WHERE USERNAME = ?", new Object[]{name}, new BeanPropertyRowMapper<>(User.class));

	}

	@Override
	public UserDetails getAdditionalUserInfo(String name) {
		return jdbcTemplate.queryForObject("SELECT ID, EMAIL, USERS_ROLES.ID_ROLE, PICTURE FROM USERS JOIN USERS_ROLES ON USERS.ID = USERS_ROLES.ID_ROLE WHERE USERNAME = ?", new Object[]{name}, new BeanPropertyRowMapper<>(UserDetails.class));
	}
	
	

}
