/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.domain.dao;

import com.sapient.auction.domain.model.User;
import com.sapient.auction.exception.UserDaoException;

/**
 * @author avish9
 * Object for read/writing {@link User} data from/to a data source.
 */
public interface UserDao {
	
	/**
	 * @param user
	 * it will create new user
	 */
	public void create(User user) throws UserDaoException;
	
	/**
	 * @param userid
	 * @return user of given id.
	 */
	public User getUser(Integer userid) throws UserDaoException;
	
	/**
	 * 
	 * @param username
	 * @return user details of given user name
	 */
	public User getUserByUserName(String username) throws UserDaoException;

	public boolean isUserExist(String username);
}
