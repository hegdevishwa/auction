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

import com.sapient.auction.constants.ApplicationConstants;
import com.sapient.auction.domain.model.Bid;
import com.sapient.auction.services.BidService;

/**
 * @author avish9 Controller for {@link Bid} resources.
 */
@Controller
public class BidController {

	/** logger */
	private static final Logger LOGGER = Logger.getLogger(BidController.class);

	

	@Autowired
	private BidService bidService;
	/**
	 * this method submit the bid of given by user.
	 * 
	 * @param bid
	 * @param model
	 */
	@RequestMapping(path = ApplicationConstants.CREATE_BID_REQUEST, method = RequestMethod.POST)
	public String placedBid(@ModelAttribute Bid bid, Model model, BindingResult bindingResult) {
		LOGGER.info("Method: placedBid called");
		bidService.placedCurrentUserBid(bid);
		return ApplicationConstants.REDIRECT + ApplicationConstants.HOME_REQUEST;

	}
}
