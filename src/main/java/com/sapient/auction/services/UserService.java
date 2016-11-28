/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.services;

import org.springframework.validation.BindingResult;

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
	public String createUser(User user, BindingResult bindingResult);
	
	/**
	 * @param userid
	 * @return user details of given userid. 
	 */
	public User getUser(Integer userid);
	
	/**
	 * @param userid
	 * @return user details of given user name. 
	 */
	public User getUserByUserName(String userName);
	
}
