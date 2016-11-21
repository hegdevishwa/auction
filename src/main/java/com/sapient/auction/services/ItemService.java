package com.sapient.auction.services;

import java.util.List;

import com.sapient.auction.dao.exception.ServiceException;
import com.sapient.auction.domain.model.Item;

public interface ItemService {

	public int createSaleItem(Item item) throws ServiceException;

	public Item getItem(Integer itemId);

	public List<Item> getActiveSaleItems();

}
