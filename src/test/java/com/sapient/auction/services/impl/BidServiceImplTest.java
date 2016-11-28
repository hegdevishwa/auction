package com.sapient.auction.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapient.auction.domain.dao.BidDao;
import com.sapient.auction.domain.model.Bid;
import com.sapient.auction.exception.BidDaoException;

/**
 * @author avish9
 * Junit test cases for bid service implementation.
 */
public class BidServiceImplTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(BidServiceImplTest.class);

	/**
	 * mocking user dao.
	 */
	@Mock
	private BidDao bidDao;

	/**
	 * mocking inject by bid service implementation.
	 */
	@InjectMocks
	private BidServiceImpl bidServiceImpl;

	/**
	 * ArgumentCaptor for bid dao.
	 */
	@Captor
	ArgumentCaptor<Bid> captor;

	private Bid bid;

	/**
	 * initialize mockito annotation.
	 */
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		bid=new Bid();
		bid.setBidId(101);
		bid.setBidPrice(12345);
		bid.setItemId(11);
		bid.setUserId(707);
	}
	
	/**
	 * {@link BidServiceImpl#getBid} Test for getting list of bid by item id.
	 */
	@Test
	public void getBid() {
		
		List<Bid> bidDetails=new ArrayList<Bid>();
		bidDetails.add(bid);
		when(bidServiceImpl.getBid(bidDetails.get(0).getItemId())).thenReturn(bidDetails);
		double value=bidServiceImpl.getBid(11).get(0).getBidPrice();
		assertEquals("12345.0",String.valueOf(value));
	}
	
	/**
	 * {@link BidServiceImpl#getBid} Test for getting exception with different item id.
	 */
	@Test
	public void getBidWithDifferentId() {

		try {
			when(bidDao.getBid(anyInt())).thenThrow(new BidDaoException("Bid not found"));
		} catch (BidDaoException e) {
			LOGGER.error("Exception while getUserWithDifferentId", e);
		}
		bidServiceImpl.getBid(1011);
	}
	
	/**
	 * {@link BidServiceImpl#placedCurrentUserBid} Test for getting exception with different item id.
	 * @throws BidDaoException 
	 */
	@Test
	public void placedCurrentUserBidWithDifferentId() throws BidDaoException {
		doThrow(BidDaoException.class).when(bidDao).placedCurrentUserBid(any(Bid.class));
		bidServiceImpl.placedCurrentUserBid(null);
	}

}
