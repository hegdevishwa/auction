/**
 * 
 */
package com.sapient.auction.domain.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sapient.auction.domain.dao.ItemDao;
import com.sapient.auction.domain.model.Item;

/**
 * @author vhegd1
 *
 */
@Repository
public class ItemDaoImpl extends BaseDaoImpl implements ItemDao {

	private static final Logger LOGGER = Logger.getLogger(ItemDaoImpl.class);

	/**
	 * Method to insert sale item in database
	 * 
	 * @param item
	 *            to be inserted
	 * @return numbe4rs of rows inserted - rowCount
	 * @throws RuntimeException
	 */
	@Override
	public int createSaleItem(Item item) {

		LOGGER.debug("Method: createSaleItem");

		int rowCount;

		String sql = "INSERT INTO item  ( name, category, description, base_bid_price, userid,image, created_date_time,  expiry_date)"
				+ "VALUES ( ?, ? ,?, ?, ?, ?, ?, ?)";
		rowCount = jdbcTemplate.update(sql,
				new Object[] { item.getName(), item.getCategory(), item.getDescription(), item.getBaseBidPrice(),
						item.getUserId(), item.getImageByteArray(), item.getCreateDateTime(), item.getExpiryDate() });
		return rowCount;
	}

	/**
	 * Method to get list of active sale items.
	 * 
	 * @return List of Items
	 */
	@Override
	public List<Item> getActiveSaleItems() {

		LOGGER.debug("Method: getActiveSaleItems");
		String sql = "select * from item where expiry_date >= now()";
		RowMapper<Item> rowMapper = new ItemRowMapper();
		return jdbcTemplate.query(sql, rowMapper);
	}

	/**
	 * To get the item details.
	 * 
	 * @param integer
	 *            - Item id
	 * @return Item
	 */
	@Override
	public Item getItem(Integer itemId) {
		LOGGER.debug("Method: getItem");
		String query = "select * from item where item_id=?";
		RowMapper<Item> rm = new ItemRowMapper();
		return jdbcTemplate.queryForObject(query, rm, itemId);
	}

	class ItemRowMapper implements RowMapper<Item> {
		@Override
		public Item mapRow(ResultSet rs, int arg1) throws SQLException {
			Item item = new Item();
			item.setItemId(rs.getInt("item_id"));
			item.setName(rs.getString("name"));
			item.setCategory(rs.getString("category"));
			item.setDescription(rs.getString("description"));
			item.setBaseBidPrice(rs.getDouble("base_bid_price"));
			item.setExpiryDate(rs.getDate("expiry_date"));
			item.setImageByteArray(rs.getBytes("image"));
			item.setUserId(rs.getInt("userid"));
			return item;
		}

	}

}
