package io.springSecurity.jwt.Repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import io.springSecurity.jwt.models.DAOUser;

@Service
public class CustomerServiceRepo {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	public List<DAOUser> findUserByName(String email) {
		/*
		 * String sql = "SELECT * FROM user WHERE username = ?"; return
		 * jdbcTemplate.query(sql,new Object[]{userNamer}, new CustomerRowMapper());
		 */
		
		String sql = "SELECT * FROM user WHERE email = ?"; return
		 jdbcTemplate.query(sql,new Object[]{email}, new CustomerRowMapper());
		
	}
	
	public int  insertUserDetaila(DAOUser user) {
		String querry ="Insert into user(firstName,lastName,address,discription,email,password) values(?,?,?,?,?,?)";
		return jdbcTemplate.update(querry,user.getFirstName(),user.getLastName(),
				user.getAddress(),user.getDiscription(),user.getEmail(),user.getPassword());
	}

	public List<DAOUser> getAllUserRegisterd() {
		// TODO Auto-generated method stub
			String SELECT_ALL_QUERY = "SELECT * FROM user"; 
		 return this.jdbcTemplate.query(SELECT_ALL_QUERY, new UserRowMapper());
		
	}
}
