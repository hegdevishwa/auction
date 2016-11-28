/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.sapient.auction.constants.ApplicationConstants;
import com.sapient.auction.domain.dao.UserDao;
import com.sapient.auction.domain.model.User;
import com.sapient.auction.exception.UserDaoException;
import com.sapient.auction.services.UserService;

/**
 * @author avish9
 * Basic {@link UserService} implementation.
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

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
	public String createUser(User user, BindingResult bindingResult) {
		LOGGER.debug("user is going to create");
		try {
			if(userDao.isUserExist(user.getUserName())){
				LOGGER.debug("User alreday registered");
				bindingResult.addError(new FieldError("user", "userName", "User already registered"));
				return ApplicationConstants.REGISTER_VIEW;
			}
			if (bindingResult.hasErrors()) {
				LOGGER.debug("error in registration field.");
				return ApplicationConstants.REGISTER_VIEW;
			}
			userDao.create(user);
		} catch (UserDaoException e) {
			LOGGER.error("User dao throw exception", e);
			return ApplicationConstants.REGISTER_VIEW;
		}
		return ApplicationConstants.LOGIN_VIEW;
	}

	/**
	 * return the user details of given id.
	 */
	@Override
	public User getUser(Integer userid) {
		try {
			return userDao.getUser(userid);
		} catch (UserDaoException e) {
			LOGGER.error("User dao throw exception because userid is not present in DB", e);
			return new User();
		}
	}
	
	/**
	 * return the user details of given user name.
	 */
	@Override
	public User getUserByUserName(String userName) {
		try {
			return userDao.getUserByUserName(userName);
		} catch (UserDaoException e) {
			LOGGER.error("User dao throw exception because user name is not present in DB", e);
		}
		return null;
	}
}
