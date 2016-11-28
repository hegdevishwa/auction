/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.controllers;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.auction.constants.ApplicationConstants;
import com.sapient.auction.domain.model.User;
import com.sapient.auction.exception.UserDaoException;
import com.sapient.auction.services.UserService;

/**
 * @author avish9
 * Controller for {@link User} resources.
 */
@Controller
public class UserController {
	
	
	
	@Autowired
	private UserService userService;

	/** logger of user controller.*/
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	
	/**
	 * this method landed to you in registration page.
	 * @param model
	 * @return
	 */
	@RequestMapping(path = ApplicationConstants.REGISTER_REQUEST, method = RequestMethod.GET)
	public String register(Model model) {
		LOGGER.debug("return register page.");
		User user = new User();
		model.addAttribute("user", user);
		return ApplicationConstants.REGISTER_VIEW;
	}
	
	/**
	 * this method will create new user and landed to you in home page.
	 * @param user
	 * @param bindingResult
	 * @return home page.
	 * @throws UserDaoException 
	 */
	@RequestMapping(path = ApplicationConstants.AUCTIONREGISTER_REQUEST, method = RequestMethod.POST)
	public String userRegistration(@Valid @ModelAttribute User user, BindingResult bindingResult) throws UserDaoException
	{
		return userService.createUser(user,bindingResult);
	}
	 
}
