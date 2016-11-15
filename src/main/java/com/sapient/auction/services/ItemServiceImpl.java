/**
 * 
 */
package com.sapient.auction.services;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.auction.domain.dao.ItemDao;
import com.sapient.auction.domain.model.Item;

@Service
public class ItemServiceImpl implements ItemService {

	private static final Logger logger = Logger.getLogger(ItemServiceImpl.class);

	@Autowired
	private ItemDao itemDao;

	@Override
	@Transactional
	public int createSaleItem(Item item) {

		logger.debug("Method: createSaleItem");

		item.setUserId(1);
		setCreateExpiryDates(item);

		try {
			item.setImageByteArray(item.getFile().getBytes());
		} catch (IOException e) {
			logger.error("Error extracting image from Multipart file.", e);
		}

		int rowCount = itemDao.createSaleItem(item);

		if (rowCount >= 1) {
			return 1;
		} else {
			return 0;
		}
	}

	private void setCreateExpiryDates(Item item) {
		item.setCreateDateTime(LocalDateTime.now());
		item.setExpiryDate(LocalDateTime.from(item.getCreateDateTime()).plusDays(3));
	}

	/**
	 * @return the itemDao
	 */
	public ItemDao getItemDao() {
		return itemDao;
	}

	/**
	 * @param itemDao
	 *            the itemDao to set
	 */
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

}
