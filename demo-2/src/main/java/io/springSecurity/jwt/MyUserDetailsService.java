package io.springSecurity.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.springSecurity.jwt.Repository.CustomerServiceRepo;
import io.springSecurity.jwt.Repository.UserDao;
import io.springSecurity.jwt.models.DAOUser;

@Service
public class MyUserDetailsService implements UserDetailsService{

	//In this class use autowire to get userDetais and password and passw in new user
	
	@Autowired
	CustomerServiceRepo service;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<DAOUser> user=service.findUserByName(email);
		return new User(user.get(0).getEmail(),user.get(0).getPassword(),new ArrayList<>());
		//return new User(user.get(0).getUsername(),user.get(0).getPassword(),new ArrayList<>());
		//return null;
	}

}
 