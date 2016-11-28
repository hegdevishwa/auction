/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.auction.dao.exception.UserDaoException;
import com.sapient.auction.domain.dao.UserDao;
import com.sapient.auction.domain.model.User;

/**
 * @author avish9
 * Basic {@link UserService} implementation.
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	/**
	 * user dao
	 */
	@Autowired
	private UserDao userDao;

	/**
	 * @param userDao
	 * set the userdao.
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * create new user
	 */
	@Override
	@Transactional
	public void createUser(User user) {
		logger.debug("user is going to create");
		try {
			userDao.create(user);
		} catch (UserDaoException e) {
			logger.error("User dao throw exception", e);
		}
	}

	/**
	 * return the user details of given id.
	 */
	@Override
	public User getUser(Integer userid) {
		try {
			return userDao.getUser(userid);
		} catch (UserDaoException e) {
			logger.error("User dao throw exception because userid is not present in DB", e);
			return new User();
		}
	}
	
	/**
	 * return the user details of given user name.
	 */
	@Override
	public List<User> getUserByUserName(String userName) {
		try {
			return userDao.getUserByUserName(userName);
		} catch (UserDaoException e) {
			logger.error("User dao throw exception because user name is not present in DB", e);
			return new ArrayList<>();
		}
	}
}
