package io.springSecurity.jwt.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.springSecurity.jwt.models.DAOUser;

public class UserRowMapper implements RowMapper<DAOUser>{

	@Override
	public DAOUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DAOUser user=new DAOUser();
		user.setId(rs.getLong("id"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setAddress(rs.getString("address"));
		user.setDiscription(rs.getString("discription"));
		user.setEmail(rs.getString("email"));
		return user;
	}

}
