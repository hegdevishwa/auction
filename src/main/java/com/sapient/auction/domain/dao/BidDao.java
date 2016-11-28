/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.domain.dao;

import java.util.List;

import com.sapient.auction.domain.model.Bid;
import com.sapient.auction.exception.BidDaoException;

/**
 * @author avish9
 * Object for read/writing {@link Bid} data from/to a data source.
 */
public interface BidDao {
	
	/**
	 * @param bidId
	 * @return 
	 */
	public List<Bid> getBid(Integer itemID) throws BidDaoException;
	
	
	/**
	 * placed a bid of current user 
	 * @param bid
	 */
	public void placedCurrentUserBid(Bid bid) throws BidDaoException;
}
