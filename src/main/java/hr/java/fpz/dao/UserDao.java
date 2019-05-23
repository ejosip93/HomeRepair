package hr.java.fpz.dao;

import java.util.List;

import hr.java.fpz.model.User;
import hr.java.fpz.model.UserDetails;

public interface UserDao {
	void addUser(User u);

	List<User> getUsers();

	User getUserByUsername(String name);
	
	UserDetails getAdditionalUserInfo(String name);
}
