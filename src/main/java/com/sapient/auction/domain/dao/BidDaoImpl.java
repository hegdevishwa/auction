/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.domain.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sapient.auction.domain.model.Bid;

/**
 * @author avish9
 * JDBC DAO implementation for {@link Bid}.
 */
@Repository
public class BidDaoImpl extends BaseDaoImpl implements BidDao{
	
	private static final Logger logger = Logger.getLogger(BidDaoImpl.class);
	
	/**
	 * it will return the bid detail of given item id.
	 */
	@Override
	public List<Bid> getBid(Integer bidId) {
		String query="select * from bid where bidprice=(select max(bidprice) from bid where item_id=?);";
		RowMapper<Bid> rm=new BidRowMapper();
		List<Bid> bidObj = jdbcTemplate.query(query, rm,bidId);
		return bidObj;
	}
	
	
	@Override
	public void placedCurrentUserBid(Bid bid) {
		String createBidQuery = "insert into bid(item_id,userid,bidprice,created_date_time) values(?,?,?,now());";

		jdbcTemplate.update(createBidQuery,
				new Object[] {bid.getItemId(),bid.getUserId(),bid.getBidPrice() });
		logger.debug("bid created");
	}
	
	/**
	 * rowmapper for bid
	 */
	class BidRowMapper implements RowMapper<Bid>{

		@Override
		public Bid mapRow(ResultSet rs, int rowNum) throws SQLException {
			Bid bid=new Bid();
			bid.setBidId(rs.getInt("bid_id"));
			bid.setItemId(rs.getInt("item_id"));
			bid.setUserId(rs.getInt("userid"));
			bid.setBidPrice(rs.getDouble("bidprice"));
			return bid;
		}
		
	}

}
