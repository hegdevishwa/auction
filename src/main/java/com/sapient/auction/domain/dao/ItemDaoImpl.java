/**
 * 
 */
package com.sapient.auction.domain.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sapient.auction.domain.model.Item;

/**
 * @author vhegd1
 *
 */
@Repository
public class ItemDaoImpl extends BaseDaoImpl implements ItemDao {

	private static final Logger logger = Logger.getLogger(ItemDaoImpl.class);

	/**
	 * Method to insert sale item in database
	 * 
	 * @param item
	 *            to be inserted
	 * @return numbe4rs of rows inserted - rowCount
	 * @throws RuntimeException
	 */
	@Override
	public int createSaleItem(Item item) throws RuntimeException {

		logger.info("Method: createSaleItem");

		int rowCount;

		System.out.println(item);
		System.out.println(item.getImageByteArray().length);

		String sql = "INSERT INTO item  ( name, category, description, base_bid_price, userid,image, created_date_time,  expiry_date)"
				+ "VALUES ( ?, ? ,?, ?, ?, ?, now(), now())";
		try {
			rowCount = jdbcTemplate.update(sql, new Object[] { item.getName(), item.getCategory(),
					item.getDescription(), item.getBaseBidPrice(), item.getUserId(), item.getImageByteArray() });
		} catch (DataAccessException e) {
			logger.error("Error inserting data in database.", e);

			throw new RuntimeException("Error inserting item data into database.");
		}

		return rowCount;
	}

	@Override
	public List<Item> getActiveSaleItems() throws RuntimeException {

		logger.info("Method: getActiveSaleItems");

		return null;
	}

}
