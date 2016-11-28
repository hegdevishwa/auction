/**
 * 
 */
package com.sapient.auction.controllers;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.sapient.auction.domain.model.Item;
import com.sapient.auction.domain.model.ItemCategories;
import com.sapient.auction.exception.ServiceException;
import com.sapient.auction.services.ItemService;

/**
 * @author vhegd1
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	@Mock
	ItemService itemService;
	@Mock
	HttpServletRequest request;
	@Mock
	HttpSession httpSession;
	@Mock
	Model model;
	@Mock
	Logger logger;
	@InjectMocks
	ItemController itemController;

	/**
	 * Nov 21, 2016void@throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Nov 21, 2016void@throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCreateSaleItem_Created() throws ServiceException {

		Item item = new Item();

		when(request.getSession(false)).thenReturn(httpSession);
		when(httpSession.getAttribute("userId")).thenReturn(10);
		when(itemService.createSaleItem(item)).thenReturn(1);

		Assert.assertEquals("redirect:/home", itemController.createSaleItem(item));
		Mockito.verify(itemService, times(1)).createSaleItem(item);
		Assert.assertEquals(10, item.getUserId());

	}

	@Test
	public final void testCreateSaleItem_NotCreated() throws ServiceException {

		Item item = new Item();

		when(request.getSession(false)).thenReturn(httpSession);
		when(httpSession.getAttribute("userId")).thenReturn(10);
		when(itemService.createSaleItem(item)).thenReturn(0);

		Assert.assertEquals(itemController.createSaleItem(item), "createSaleItem");
		Mockito.verify(itemService, times(1)).createSaleItem(item);
		Assert.assertEquals(item.getUserId(), 10);
	}

	@Test
	public final void testCreateSaleItem_Exception() throws ServiceException {

		Item item = new Item();

		when(request.getSession(false)).thenReturn(httpSession);
		when(httpSession.getAttribute("userId")).thenReturn(10);
		when(itemService.createSaleItem(item)).thenReturn(0);

		Assert.assertEquals(itemController.createSaleItem(item), "createSaleItem");
		Mockito.verify(itemService, times(1)).createSaleItem(item);
		Assert.assertEquals(item.getUserId(), 10);
	}

	@Test
	public final void testCreateSaleItemPagNav() {
		Item i = new Item();
		when(model.addAttribute("item", i)).thenReturn(model);
		when(model.addAttribute("categories", ItemCategories.values())).thenReturn(model);
		Assert.assertEquals(itemController.createSaleItemPagNav(model), "createSaleItem");
		Mockito.verify(model, times(2)).addAttribute(Mockito.anyString(), Mockito.any());
		
	}

	/**
	 * Test method for
	 * {@link com.sapient.auction.controllers.ItemController#getActiveSaleItems(org.springframework.ui.Model)}.
	 */
	@Test
	public final void testGetActiveSaleItems() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link com.sapient.auction.controllers.ItemController#getItem(int, org.springframework.ui.Model, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	public final void testGetItem() {
		fail("Not yet implemented"); // TODO
	}

}
