package com.sapient.auction.controllers;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.auction.domain.model.Bid;

@Controller
public class BidController {

	private static final Logger logger = Logger.getLogger(BidController.class);

	@RequestMapping(path = "createbidForItem", method = RequestMethod.GET)
	public String latestBidDetails(Model model) {

		// check if user is login
		String userName = "";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			userName=userDetail.getUsername();
		}

		logger.info("Method:latest bid details");
		Bid bid = new Bid();
		model.addAttribute("bid", bid);
		model.addAttribute("uname", userName);
		return "bidPage";
	}

	@RequestMapping(path = "/createbidForItem", method = RequestMethod.POST)
	public String createSaleItem(@ModelAttribute Bid bid, Model model) {
		logger.info("Method: registration page");
		System.out.println(bid);
		// userDao.create(user);
		return "home";

	}
}
