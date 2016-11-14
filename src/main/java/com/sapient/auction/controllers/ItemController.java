package com.sapient.auction.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sapient.auction.domain.model.Item;
import com.sapient.auction.services.ItemService;

@Controller
public class ItemController {

	private static final Logger logger = Logger.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;

	@RequestMapping(path = "/items", method = RequestMethod.POST)
	public String createSaleItem(@ModelAttribute Item item, @RequestParam CommonsMultipartFile fil, Model model) {

		logger.info("Method: createSaleItem");

		itemService.createSaleItem(item);

		return "home";

	}

	@RequestMapping(path = "createsaleitem", method = RequestMethod.GET)
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
