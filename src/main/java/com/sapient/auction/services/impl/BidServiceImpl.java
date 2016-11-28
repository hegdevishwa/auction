/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.auction.domain.dao.BidDao;
import com.sapient.auction.domain.model.Bid;
import com.sapient.auction.exception.BidDaoException;
import com.sapient.auction.services.BidService;

/**
 * @author avish9 Basic {@link BidService} implementation.
 */
@Service
public class BidServiceImpl implements BidService {

	private static final Logger LOGGER = Logger.getLogger(BidServiceImpl.class);

	@Autowired
	private BidDao bidDao;

	@Override
	public List<Bid> getBid(Integer itemId) {
		LOGGER.debug("geting bid details of given item id");
		try {
			return bidDao.getBid(itemId);
		} catch (BidDaoException e) {
			LOGGER.error("User dao throw exception", e);
			return new ArrayList<>();
		}
	}

	@Override
	public void placedCurrentUserBid(Bid bid) {
		LOGGER.info("bid details is goiong to save");
		try {
			bidDao.placedCurrentUserBid(bid);
		} catch (BidDaoException e) {
			LOGGER.error("User dao throw exception", e);
		}
	}
}
