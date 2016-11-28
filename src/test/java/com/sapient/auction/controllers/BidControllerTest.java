/**
 * 
 */
package com.sapient.auction.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sapient.auction.domain.dao.BidDao;
import com.sapient.auction.domain.model.Bid;
import com.sapient.auction.exception.BidDaoException;
import com.sapient.auction.services.impl.BidServiceImpl;

/**
 * @author ashu21
 *
 */
public class BidControllerTest {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private MockMvc mockMvc;
	
	/**
	 * ArgumentCaptor for Bid dao.
	 */
	@Captor
    ArgumentCaptor<Bid> captor;
	
	private Bid bid;

	/**
	 * 
	 */
	@InjectMocks
	private BidServiceImpl bidServiceImpl;
	
	@Mock
	private BidDao bidDao;
	/**
	 * initialize mockito annotation.
	 */
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(bidServiceImpl).build();
		
		bid=new Bid();
		bid.setBidId(32);
		bid.setBidPrice(10);
		bid.setItemId(6);
		bid.setUserId(1);
		bid.setCreatedDate(new Date());
	}
	
	@Test
	public void createSaleItem() throws BidDaoException{
		/*
         * Instruct mockito to do nothing when will be called.
         */
		doNothing().when(bidDao).placedCurrentUserBid(any(Bid.class));
		bidServiceImpl.placedCurrentUserBid(bid);
		
		verify(bidDao, times(1)).placedCurrentUserBid(captor.capture());
		assertEquals(captor.getValue().getBidId(),32);
	}
}
