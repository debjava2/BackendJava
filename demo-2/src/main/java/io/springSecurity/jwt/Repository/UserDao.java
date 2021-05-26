package io.springSecurity.jwt.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.springSecurity.jwt.models.DAOUser;


@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	
	// DAOUser findByUsername(String username);
	
}