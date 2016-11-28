package com.sapient.auction.domain.dao.impl;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.auction.domain.dao.UserDao;
import com.sapient.auction.domain.model.User;
import com.sapient.auction.exception.UserDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:root-context.xml", "classpath:servlet-context.xml",
		"classpath:spring-database.xml", "classpath:spring-security.xml" })
public class UserDaoImplTest {

	@Autowired
	private UserDao userDao;

	@Test
	@Transactional
	@Rollback(true)
	public void test() throws UserDaoException {

		String userName = RandomStringUtils.random(8, true, true);

		User user = new User();
		user.setFirstName("amit");
		user.setUserName(userName);
		user.setLastName("Vishwakarma");
		user.setAddress("Bangalore");
		user.setPassword("123456");

		userDao.create(user);
		User userByName = userDao.getUserByUserName(userName);
		User userById = userDao.getUser(userByName.getUserId());
		boolean userIsExist=userDao.isUserExist(user.getUserName());
		boolean userNotExist=userDao.isUserExist("dsadas");

		assertEquals(userByName.getFirstName(), user.getFirstName());
		assertEquals(userByName.getAddress(), user.getAddress());
		assertEquals(userByName.getUserName(), user.getUserName());

		assertEquals(userById.getFirstName(), user.getFirstName());
		assertEquals(userById.getAddress(), user.getAddress());
		assertEquals(userById.getUserName(), user.getUserName());
		
		assertEquals(true, userIsExist);
		assertEquals(false, userNotExist);
	}

}
