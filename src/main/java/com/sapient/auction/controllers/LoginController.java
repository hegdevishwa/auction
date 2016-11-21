package com.sapient.auction.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.auction.dao.exception.UserDaoException;
import com.sapient.auction.domain.dao.UserDao;
import com.sapient.auction.domain.model.User;

@Controller
public class LoginController {

	@Autowired
	private UserDao userDao;

	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(HttpServletRequest request ,Model model ) throws UserDaoException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    if (auth instanceof AnonymousAuthenticationToken) {
	    	model.addAttribute("msg", "Pls Login First");
	    	return "login";	
		}
	    else{
	    HttpSession session = request.getSession(false);
	    
	    User user= userDao.getUserByUserName(name).get(0);
	    
	    session.setAttribute("username",user.getUserName() );
	    session.setAttribute("userId",user.getUserId() );	    
		model.addAttribute("user", user);
		model.addAttribute("title", "Auction Login Form - Database Authentication");
		model.addAttribute("message", "This is default page!");
		model.addAttribute("fname", user.getFname());
	    }
		return "home";

	}

	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView defaultPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			
		}
		
		model.setViewName("403");
		return model;

	}

}