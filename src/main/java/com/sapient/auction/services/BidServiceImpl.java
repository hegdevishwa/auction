/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.auction.domain.dao.BidDao;
import com.sapient.auction.domain.model.Bid;

/**
 * @author avish9
 * Basic {@link BidService} implementation.
 */
@Service
public class BidServiceImpl implements BidService{

	private static final Logger logger = Logger.getLogger(BidServiceImpl.class);
	
	@Autowired
	private BidDao bidDao;

	@Override
	public List<Bid> getBid(Integer bidId) {
		logger.debug("geting bid details of given item id");
		return bidDao.getBid(bidId);
	}

	@Override
	public void placedCurrentUserBid(Bid bid) {
		logger.info("bid details is goiong to save");
		bidDao.placedCurrentUserBid(bid);
	}
}
