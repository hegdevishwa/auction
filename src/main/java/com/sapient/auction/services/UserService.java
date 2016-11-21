/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.services;

import java.util.List;

import com.sapient.auction.domain.model.User;

/**
 * @author avish9
 * Service for operating upon {@link User} objects.
 */
public interface UserService {
	
	/**
	 * @param user
	 * create new user.
	 */
	public void createUser(User user);
	
	/**
	 * @param userid
	 * @return user details of given userid. 
	 */
	public User getUser(Integer userid);
	
	/**
	 * @param userid
	 * @return user details of given user name. 
	 */
	public List<User> getUserByUserName(String userName);
	
}
