/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.services;

import java.util.List;

import com.sapient.auction.domain.model.Bid;

/**
 * @author avish9
 * Service for operating upon {@link Bid} objects.
 */
public interface BidService {

	/**
	 * @param bidId
	 * @return bid object of given item id
	 */
	public List<Bid> getBid(Integer bidId);
	
	/**
	 * placed a bid of current user 
	 * @param bid
	 */
	public void placedCurrentUserBid(Bid bid);
}
