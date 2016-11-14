package com.sapient.auction.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuctionController {

	@RequestMapping("/index")
	public ModelAndView getIndexPage(){
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg","Hello from spring MVC");
		mav.setViewName("home");
		return mav;
	}

}
