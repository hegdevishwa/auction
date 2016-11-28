package com.sapient.auction.domain.dao.impl;

import static org.junit.Assert.assertNotEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.auction.domain.dao.BidDao;
import com.sapient.auction.domain.model.Bid;
import com.sapient.auction.exception.BidDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:root-context.xml", "classpath:servlet-context.xml",
		"classpath:spring-database.xml", "classpath:spring-security.xml" })
public class BidDaoImplTest {

	@Autowired
	private BidDao bidDao;
	@Test
	@Transactional
	@Rollback(true)
	public void test() throws BidDaoException {
		
		Bid bid = new Bid();
		bid.setBidId(11);
		bid.setBidPrice(10);
		bid.setCreatedDate(new Date());
		bid.setItemId(9);
		bid.setUserId(1);
        bidDao.placedCurrentUserBid(bid);
		List<Bid>	bidlist = bidDao.getBid(9);
		assertNotEquals(bidlist.get(0).getBidId(), bid.getBidId());
			//assertEquals(bidlist.get(1).getBidPrice(), bid.getBidPrice());
		
		
		
	}

}
