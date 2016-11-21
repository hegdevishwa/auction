/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.auction.domain.dao.BidDao;
import com.sapient.auction.domain.model.Bid;

/**
 * @author avish9
 * Controller for {@link Bid} resources.
 */
@Controller
public class BidController {

	/** logger */
	private static final Logger logger = Logger.getLogger(BidController.class);
	
	/**
	 * user dao.
	 */
	@Autowired
	private BidDao bidDao;

	/**
	 * this method submit the bid of given by user.
	 * @param bid
	 * @param model
	 */
	@RequestMapping(path = "/items/createbidForItem", method = RequestMethod.POST)
	public String createSaleItem(@ModelAttribute Bid bid, Model model,BindingResult bindingResult) {
		logger.info("Method: registration page");
		System.out.println(bid);
		bidDao.placedCurrentUserBid(bid);
		logger.info("bid created");
		// userDao.create(user);
		return "redirect:/home";

	}
}
