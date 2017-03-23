/**
 * 
 */
package com.simple.crud;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simple.crud.dao.UserDao;
import com.simple.crud.model.User;

/**
 * @author eotayde
 *
 */
public class UserDaoTest {

	private ApplicationContext context;
	private UserDao userDao;
	
	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("spring-beans.xml");
		userDao = (UserDao) context.getBean("userDaoImpl");
	}

	public void testDelete() {
		userDao.deleteById(2);
	}
	
	public void testUpdate() {
		User oldUser = userDao.findById(2);
		oldUser.setFirstName("jayjay");
		userDao.update(oldUser);	
	}
	
	public void testGet() {
		try {
			User user = userDao.findById(1);
			
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAll() {
		List<User> userList = userDao.findAll();
		
		for (User u : userList) {
			System.out.println(u.toString());
		}
	}

	public void testAdd() {
		User user = new User();
		user.setFirstName("jayjay");
		user.setLastName("pogi");
		user.setId(3);
		
		userDao.create(user);
	}

}
