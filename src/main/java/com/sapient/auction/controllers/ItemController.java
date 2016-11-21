package com.sapient.auction.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.auction.dao.exception.ServiceException;
import com.sapient.auction.domain.model.Bid;
import com.sapient.auction.domain.model.Item;
import com.sapient.auction.domain.model.User;
import com.sapient.auction.services.BidService;
import com.sapient.auction.services.ItemService;
import com.sapient.auction.services.UserService;

@Controller
public class ItemController {

	private static final Logger logger = Logger.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;

	@Autowired
	private BidService bidService;

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/items", method = RequestMethod.POST)
	public String createSaleItem(@ModelAttribute Item item, HttpServletRequest request) throws ServiceException {

		logger.info("Method: createSaleItem");

		HttpSession session = request.getSession(false);
		Integer userId = (Integer) session.getAttribute("userId");
		item.setUserId(userId);

		int result = itemService.createSaleItem(item);

		if (result >= 1) {
			return "redirect:/home";
		} else {
			
			return "createSaleItem";
		}
	}

	/**
	 * 
	 * @param model
	 * @return JSP page
	 */
	@RequestMapping(path = "/createSaleItem", method = RequestMethod.GET)
	public String createSaleItemPagNav(Model model) {

		logger.info("Method:createSaleItemPagNav");

		Item item = new Item();
		model.addAttribute("item", item);
		List<String> categories = new ArrayList<>();
		categories.add("Mobile Phone");
		categories.add("Home appliance");
		categories.add("Two wheeler");
		categories.add("Four wheeler");

		model.addAttribute("categories", categories);

		return "createSaleItem";
	}

	@RequestMapping(path = "/items", method = RequestMethod.GET)
	public String getActiveSaleItems(Model model) {

		List<Item> items = itemService.getActiveSaleItems();
		model.addAttribute("items", items);

		return "saleItems";
	}

	@RequestMapping(path = "/items/{itemId}", method = RequestMethod.GET)
	public String getItem(@PathVariable(value = "itemId") int itemId, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		Integer userId = (Integer) session.getAttribute("userId");

		Item itemResult = itemService.getItem(itemId);
		model.addAttribute("item", itemResult);
		List<Bid> bidDetails = bidService.getBid(itemResult.getItemId());
		User cureentUser = userService.getUser(userId);
		model.addAttribute("currentUser", cureentUser);
		if (bidDetails.size() != 1) {
			Bid obj = new Bid();
			model.addAttribute("bid", obj);
			return "itemDetails";
		}

		User lastBidUser = userService.getUser(bidDetails.get(0).getUserId());
		model.addAttribute("bid", bidDetails.get(0));
		model.addAttribute("user", lastBidUser);

		return "itemDetails";
	}

	@ExceptionHandler({ ServiceException.class, Exception.class })
	public String handleExceptions(Exception e, Model model) {

		model.addAttribute("errorMessage", e.getMessage());
		logger.info(e.getMessage());
		return "error";
	}

	/**
	 * @return the itemService
	 */
	public ItemService getItemService() {
		return itemService;
	}

	/**
	 * @param itemService
	 *            the itemService to set
	 */
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

}
