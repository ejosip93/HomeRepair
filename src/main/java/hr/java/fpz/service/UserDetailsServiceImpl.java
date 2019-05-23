package hr.java.fpz.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hr.java.fpz.dao.UserDao;
import hr.java.fpz.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {
		
		List<User> users = userDao.getUsers();
		User user = userDao.getUserByUsername(name);
		UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
		
		builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		switch(user.getUserType().intValue()){
		case 1:
			builder.roles("ADMIN");
		case 3:
			builder.roles("BUSINESS");
		default:
			builder.roles("CLIENT");
		}		
		return builder.build();
	}

}
