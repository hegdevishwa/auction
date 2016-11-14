/**
 * 
 */
package com.sapient.auction.services;

import java.util.Date;

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
	public String createSaleItem(Item item) {

		logger.debug("Method: createSaleItem");

		item.setCreatedBy("Vishwa");
		item.setCreateDateTime(new Date());
		itemDao.createSaleItem(item);

		return null;
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
