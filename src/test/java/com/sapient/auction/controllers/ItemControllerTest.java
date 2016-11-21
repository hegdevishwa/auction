/**
 * 
 */
package com.sapient.auction.controllers;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;

import com.sapient.auction.dao.exception.ServiceException;
import com.sapient.auction.domain.model.Item;
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

	/**
	 * Test method for
	 * {@link com.sapient.auction.controllers.ItemController#createSaleItem(com.sapient.auction.domain.model.Item, org.springframework.validation.BindingResult, javax.servlet.http.HttpServletRequest)}.
	 * 
	 * @throws ServiceException
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public final void testCreateSaleItem_success() throws ServiceException {

		Item item = new Item();

		when(request.getSession(false)).thenReturn(httpSession);
		when(httpSession.getAttribute("userId")).thenReturn(10);
		when(itemService.createSaleItem(item)).thenReturn(1);

		Assert.assertEquals(itemController.createSaleItem(item, request), "home");
		Mockito.verify(itemService, times(1)).createSaleItem(item);
	}

	/**
	 * Test method for
	 * {@link com.sapient.auction.controllers.ItemController#createSaleItemPagNav(org.springframework.ui.Model)}.
	 */
	@Test
	public final void testCreateSaleItemPagNav() {
		fail("Not yet implemented"); // TODO
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
