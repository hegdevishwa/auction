/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BindingResult;

import com.sapient.auction.constants.ApplicationConstants;
import com.sapient.auction.domain.dao.UserDao;
import com.sapient.auction.domain.model.User;
import com.sapient.auction.services.UserService;

/**
 * @author avish9 User controller test cases.
 */

public class UserControllerTest {

	/**
	 * mocking user service.
	 */
	@Mock
	private UserService userService;
	
	@Mock
	private UserDao userDao;

	/**
	 * mocking http request
	 */
	@Mock
	private HttpServletRequest request;

	/**
	 * mocking http session
	 */
	@Mock
	private HttpSession httpSession;

	@InjectMocks
	private UserController userController;
	

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testRegister() throws Exception {
		when(httpSession.getAttribute("userId")).thenReturn(1);
		Assert.assertEquals("register", userController.register(new ExtendedModelMap()));
	}

	@Test
	public void testRegisterWithNewUser() throws Exception {
		User user=new User();
		BindingResult result = mock(BindingResult.class);
		when(userService.createUser(user, result)).thenReturn(ApplicationConstants.LOGIN_VIEW);
		Assert.assertEquals(ApplicationConstants.LOGIN_VIEW, userController.userRegistration(user, result));
	}
	
	@Test
	public void testRegisterWithExistingUser() throws Exception {
		User user=new User();
		BindingResult result = mock(BindingResult.class);
		when(userService.createUser(user, result)).thenReturn(ApplicationConstants.REGISTER_VIEW);
		Assert.assertEquals(ApplicationConstants.REGISTER_VIEW, userController.userRegistration(user, result));
	}

}
