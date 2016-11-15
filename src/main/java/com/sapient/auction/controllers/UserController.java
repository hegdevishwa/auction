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

import com.sapient.auction.domain.dao.UserDao;
import com.sapient.auction.domain.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;

	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		System.out.println("Hello");
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	
	@RequestMapping(path = "/auctionRegistration", method = RequestMethod.POST)
	public String createSaleItem(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		logger.info("Method: registration page");
		System.out.println(user);
		if (bindingResult.hasErrors()) {
			System.out.println("sagfsafja:---errror");
            return "register";
        }
		userDao.create(user);
		return "home";

	}
	
}
