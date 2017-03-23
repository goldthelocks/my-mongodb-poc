/**
 * 
 */
package com.simple.crud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.simple.crud.model.User;

/**
 * @author eotayde
 *
 */
@Repository
public interface UserDao {

	void create(User user);
	
	void update(User user);
	
	int deleteById(int id);
	
	User findById(int id);
	
	List<User> findAll();
	
}
