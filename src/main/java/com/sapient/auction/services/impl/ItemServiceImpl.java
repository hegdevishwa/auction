package com.sapient.auction.services.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.auction.constants.ApplicationConstants;
import com.sapient.auction.domain.dao.ItemDao;
import com.sapient.auction.domain.model.Item;
import com.sapient.auction.exception.ServiceException;
import com.sapient.auction.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	private static final Logger LOGGER = Logger.getLogger(ItemServiceImpl.class);

	@Autowired
	private ItemDao itemDao;

	/**
	 * Creates a sale
	 * 
	 * @param Item
	 * @return response code: 0-failure, 1-success
	 * 
	 */
	@Override
	@Transactional
	public int createSaleItem(Item item) throws ServiceException {

		LOGGER.debug("Method: createSaleItem");

		setCreateExpiryDates(item);
		try {
			item.setImageByteArray(item.getFile().getBytes());
			return itemDao.createSaleItem(item);
		} catch (IOException e) {
			LOGGER.error("Error extracting image from Multipart file.", e);
			throw new ServiceException("Error extracting image from Multipart file.", e);
		}
	}

	/**
	 * Returns active sale items
	 * 
	 * @return List of active items
	 * @throws ServiceException
	 */
	@Override
	public List<Item> getActiveSaleItems() throws ServiceException {

		List<Item> items = itemDao.getActiveSaleItems();

		if (null == items || items.isEmpty()) {
			LOGGER.info("No active sale items available.");
			throw new ServiceException("No active sale items found.");
		}

		LOGGER.debug("Method: getActiveSaleItems");
		for (Item item : items) {
			try {
				item.setBase64EncodedImage(convertToBase64Encoded(item.getImageByteArray()));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error("Error is getting for fetching list of item", e);
			}
		}
		return items;
	}

	/**
	 * Method to get item details
	 * 
	 * @param Integer
	 *            itemId
	 * 
	 * @return item details
	 */
	@Override
	public Item getItem(Integer itemId) {

		LOGGER.debug("Method: getItem");

		Item item = itemDao.getItem(itemId);
		try {
			item.setBase64EncodedImage(convertToBase64Encoded(item.getImageByteArray()));
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("Error is getting for fetching item", e);
		}
		return item;
	}

	/**
	 * 
	 * @param item
	 */
	private void setCreateExpiryDates(Item item) {
		item.setCreateDateTime(new Date());
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DATE, ApplicationConstants.THREE);
		item.setExpiryDate(calender.getTime());
	}

	/**
	 * 
	 * String @param image String @return
	 * 
	 * @throws UnsupportedEncodingException
	 */
	private String convertToBase64Encoded(byte[] image) throws UnsupportedEncodingException {
		byte[] encoded = Base64.encode(image);
		String base64Encoded = null;
		try {
			base64Encoded = new String(encoded, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("Error converting image from byte array to base64 encoded string.", e);
			throw e;
		}
		return base64Encoded;
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
