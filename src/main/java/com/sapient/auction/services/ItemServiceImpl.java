package com.sapient.auction.services;

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

import com.sapient.auction.dao.exception.ServiceException;
import com.sapient.auction.domain.dao.ItemDao;
import com.sapient.auction.domain.model.Item;

@Service
public class ItemServiceImpl implements ItemService {

	private static final Logger logger = Logger.getLogger(ItemServiceImpl.class);

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

		logger.debug("Method: createSaleItem");

		setCreateExpiryDates(item);
		try {
			item.setImageByteArray(item.getFile().getBytes());
			return itemDao.createSaleItem(item);
		} catch (IOException e) {
			logger.error("Error extracting image from Multipart file.", e);
			throw new ServiceException("Error extracting image from Multipart file.", e);
		}
	}

	/**
	 * Returns active sale items
	 * 
	 * @return List of active items
	 */
	@Override
	public List<Item> getActiveSaleItems() {

		List<Item> items = itemDao.getActiveSaleItems();
		logger.debug("Method: getActiveSaleItems");

		for (Item item : items) {
			try {
				item.setBase64EncodedImage(convertToBase64Encoded(item.getImageByteArray()));
			} catch (UnsupportedEncodingException e) {
				logger.error("Error converting image from byte array to base64 encoded string.", e);
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

		logger.debug("Method: getItem");

		Item item = itemDao.getItem(itemId);
		try {
			item.setBase64EncodedImage(convertToBase64Encoded(item.getImageByteArray()));
		} catch (UnsupportedEncodingException e) {
			logger.debug("Error converting image from byte array to base64 encoded string.", e);
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
		calender.add(Calendar.DATE, 3);
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
			logger.debug("Error converting image from byte array to base64 encoded string.", e);
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
