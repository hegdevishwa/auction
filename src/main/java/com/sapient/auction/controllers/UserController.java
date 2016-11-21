/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.auction.dao.exception.UserDaoException;
import com.sapient.auction.domain.dao.UserDao;
import com.sapient.auction.domain.model.User;

/**
 * @author avish9
 * Controller for {@link User} resources.
 */
@Controller
public class UserController {
	
	/**
	 * user dao.
	 */
	@Autowired
	private UserDao userDao;

	/** logger of user controller.*/
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	/**
	 * this method landed to you in registration page.
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		System.out.println("Hello");
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	/**
	 * this method will create new user and landed to you in home page.
	 * @param user
	 * @param bindingResult
	 * @return home page.
	 * @throws UserDaoException 
	 */
	@RequestMapping(path = "/auctionRegistration", method = RequestMethod.POST)
	public String createSaleItem(@Valid @ModelAttribute User user, BindingResult bindingResult) throws UserDaoException {
		logger.info("Method: registration page");
		System.out.println(user);
		if (bindingResult.hasErrors()) {
			logger.debug("error in registration field.");
            return "register";
        }
		List<User> userDetails=userDao.getUserByUserName(user.getUserName());
		if(userDetails.size()==1){
			logger.debug("User alreday registered");
			return "redirect:/register";
		}else{
			userDao.create(user);
			return "login";
		}
		

	}
	
}
