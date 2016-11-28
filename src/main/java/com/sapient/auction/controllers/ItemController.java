package com.sapient.auction.controllers;

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

import com.sapient.auction.constants.ApplicationConstants;
import com.sapient.auction.domain.model.Bid;
import com.sapient.auction.domain.model.Item;
import com.sapient.auction.domain.model.ItemCategories;
import com.sapient.auction.domain.model.User;
import com.sapient.auction.exception.ServiceException;
import com.sapient.auction.services.BidService;
import com.sapient.auction.services.ItemService;
import com.sapient.auction.services.UserService;

@Controller
public class ItemController {

	private static final Logger LOGGER = Logger.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;

	@Autowired
	private BidService bidService;

	@Autowired
	private UserService userService;

	@RequestMapping(path = ApplicationConstants.ITEMS_REQUEST, method = RequestMethod.POST)
	public String createSaleItem(@ModelAttribute Item item) throws ServiceException {

		LOGGER.debug("Method: createSaleItem");
		int result = itemService.createSaleItem(item);

		if (result >= 1) {
			return ApplicationConstants.REDIRECT + ApplicationConstants.HOME_REQUEST;
		} else {
			return ApplicationConstants.CREATESALEITEM_VIEW;
		}
	}

	/**
	 * 
	 * @param model
	 * @return JSP page
	 */
	@RequestMapping(path = ApplicationConstants.CREATE_ITEM_REQUEST, method = RequestMethod.GET)
	public String createSaleItemPagNav(Model model) {

		model.addAttribute("item", new Item());
		model.addAttribute("categories", ItemCategories.values());

		return ApplicationConstants.CREATESALEITEM_VIEW;
	}

	@RequestMapping(path = ApplicationConstants.ITEMS_REQUEST, method = RequestMethod.GET)
	public String getActiveSaleItems(Model model) throws ServiceException {

		List<Item> items = itemService.getActiveSaleItems();
		model.addAttribute("items", items);

		return ApplicationConstants.SALEITEM_VIEW;
	}

	@RequestMapping(path = ApplicationConstants.GET_ITEM_REQUEST, method = RequestMethod.GET)
	public String getItem(@PathVariable(value = "itemId") int itemId, Model model, HttpServletRequest request) throws ServiceException {

		HttpSession session = request.getSession(false);
		Integer userId = (Integer) session.getAttribute("userId");

		Item itemResult = itemService.getItem(itemId);
		model.addAttribute("item", itemResult);
		List<Bid> bidDetails = bidService.getBid(itemResult.getItemId());
		User cureentUser = userService.getUser(userId);
		model.addAttribute("currentUser", cureentUser);
		if (bidDetails.size() != 1) {
			Bid bid = new Bid();
			model.addAttribute("bid", bid);
			return ApplicationConstants.ITEMDETAILS_VIEW;
		}

		User lastBidUser = userService.getUser(bidDetails.get(0).getUserId());
		model.addAttribute("bid", bidDetails.get(0));
		model.addAttribute("user", lastBidUser);

		return ApplicationConstants.ITEMDETAILS_VIEW;
	}

	@ExceptionHandler({ ServiceException.class, Exception.class })
	public String handleExceptions(Exception e, Model model) {

		model.addAttribute("errorMessage", e.getMessage());
		LOGGER.info(e.getMessage());
		return  ApplicationConstants.ERROR_VIEW;
	}

}
