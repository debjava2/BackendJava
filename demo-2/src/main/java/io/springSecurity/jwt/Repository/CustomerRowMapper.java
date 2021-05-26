package io.springSecurity.jwt.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.springSecurity.jwt.models.DAOUser;

public class CustomerRowMapper implements RowMapper<DAOUser> {
	@Override
    public DAOUser mapRow(ResultSet rs, int rowNum) throws SQLException {

		DAOUser dao = new DAOUser();
		dao.setEmail(rs.getString("email"));
		
		//dao.setUsername(rs.getString("username"));
		dao.setPassword(rs.getString("password"));
		
		/*
		 * customer.setID(rs.getLong("ID")); customer.setName(rs.getString("NAME"));
		 * customer.setAge(rs.getInt("AGE"));
		 * customer.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
		 */

        return dao;

    }
}
