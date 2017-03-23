/**
 * 
 */
package com.simple.crud.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.simple.crud.dao.UserDao;
import com.simple.crud.model.User;

/**
 * @author eotayde
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	private static final String COLLECTION = "User";
	
	@Autowired
	private MongoTemplate mongoTemplate;

	/* (non-Javadoc)
	 * @see com.simple.crud.dao.UserDao#create(com.simple.crud.model.User)
	 */
	public void create(User user) {
		this.mongoTemplate.insert(user, COLLECTION);
	}

	/* (non-Javadoc)
	 * @see com.simple.crud.dao.UserDao#update(com.simple.crud.model.User)
	 */
	public void update(User user) {
		this.mongoTemplate.save(user, COLLECTION);
	}

	/* (non-Javadoc)
	 * @see com.simple.crud.dao.UserDao#deleteById(int)
	 */
	public int deleteById(int id) {
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = this.mongoTemplate.remove(query, User.class, COLLECTION);
		return result.getN();
	}

	/* (non-Javadoc)
	 * @see com.simple.crud.dao.UserDao#findById(int)
	 */
	public User findById(int id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoTemplate.findOne(query, User.class, COLLECTION);
	}

	/* (non-Javadoc)
	 * @see com.simple.crud.dao.UserDao#findAll()
	 */
	public List<User> findAll() {
		return this.mongoTemplate.findAll(User.class, COLLECTION);
	}

}
