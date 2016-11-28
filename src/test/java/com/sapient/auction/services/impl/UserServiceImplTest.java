package com.sapient.auction.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

import com.sapient.auction.constants.ApplicationConstants;
import com.sapient.auction.domain.dao.UserDao;
import com.sapient.auction.domain.model.User;
import com.sapient.auction.exception.UserDaoException;

public class UserServiceImplTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImplTest.class);

	/**
	 * mocking user dao.
	 */
	@Mock
	private UserDao userDao;
	
	@Mock
	BindingResult result;

	// /**
	// * mocking user service.
	// */
	// @Mock
	// private UserService userService;

	/**
	 * mocking inject by user service implementation.
	 */
	@InjectMocks
	private UserServiceImpl userServiceImpl;

	/**
	 * ArgumentCaptor for user dao.
	 */
	@Captor
	ArgumentCaptor<User> captor;

	private User user;

	/**
	 * initialize mockito annotation.
	 */
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		// mockMvc = MockMvcBuilders.standaloneSetup(userServiceImpl).build();

		user = new User();
		user.setUserId(707);
		user.setFirstName("amit");
		user.setLastName("vish");
		user.setUserName("amit");
		user.setPassword("123");
	}

	/**
	 * {@link UserServiceImpl#getUser} Test for getting user by id.
	 */
	@Test
	public void getUser() {

		when(userServiceImpl.getUser(user.getUserId())).thenReturn(user);
		assertEquals(userServiceImpl.getUser(707).getFirstName(), "amit");
	}


	/**
	 * {@link UserServiceImpl#getUser} Test for getting user with different id.
	 */
	@Test
	public void getUserWithDifferentId() {

		try {
			when(userDao.getUser(anyInt())).thenThrow(new UserDaoException("user not found"));
		} catch (UserDaoException e) {
			LOGGER.error("Exception while getUserWithDifferentId", e);
		}
		userServiceImpl.getUser(77);
	}

	/**
	 * {@link UserServiceImpl#getUserByUserName} Test for getting user by
	 * username.
	 */
	@Test
	public void getUserByName() {
		when(userServiceImpl.getUserByUserName("amit")).thenReturn(user);
		assertEquals(userServiceImpl.getUserByUserName("amit").getLastName(), "vish");
	}
	
	/**
	 * {@link UserServiceImpl#getUserByUserName} Test for getting user by
	 * username.
	 */
	@Test
	public void getUserWithDifferentName() {
		
		try {
			when(userDao.getUserByUserName(anyString())).thenThrow(new UserDaoException("user not found"));
		} catch (UserDaoException e) {
			LOGGER.error("Exception while getUserWithDifferentName ", e);
		}
		userServiceImpl.getUserByUserName("amit");
	}

	/**
	 * {@link UserServiceImpl#create} Test for creating new user.
	 */
	@Test
	public void createUser() throws UserDaoException {
		/*
		 * Instruct mockito to do nothing when userDao.create will be called.
		 */
		when(userDao.isUserExist(anyString())).thenReturn(false);
		when(result.hasErrors()).thenReturn(false);
		doNothing().when(userDao).create(any(User.class));
		Assert.assertEquals(ApplicationConstants.LOGIN_VIEW, userServiceImpl.createUser(user, result));
		verify(userDao, times(1)).create(any(User.class));
	}
	
	/**
	 * {@link UserServiceImpl#create} Test for creating new user with null user value.
	 */
	@Test
	public void createUserWithIsUserExist() throws UserDaoException {
		when(userDao.isUserExist(anyString())).thenReturn(true);
		Assert.assertEquals(ApplicationConstants.REGISTER_VIEW, userServiceImpl.createUser(user, result));
	}
	
	/**
	 * {@link UserServiceImpl#create} Test for creating new user with null user value.
	 */
	@Test
	public void createUserWithHasErrors() throws UserDaoException {
		when(result.hasErrors()).thenReturn(true);
		Assert.assertEquals(ApplicationConstants.REGISTER_VIEW, userServiceImpl.createUser(user, result));
	}
	
	/**
	 * {@link UserServiceImpl#create} Test for creating new user with null user value.
	 */
	@Test
	public void createUserWithException() throws UserDaoException {
		when(userDao.isUserExist(anyString())).thenReturn(false);
		when(result.hasErrors()).thenReturn(false);
		doThrow(UserDaoException.class).when(userDao).create(any(User.class));
		Assert.assertEquals(ApplicationConstants.REGISTER_VIEW, userServiceImpl.createUser(user, result));
	}
}
