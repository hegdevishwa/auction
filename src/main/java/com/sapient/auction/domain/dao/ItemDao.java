package com.sapient.auction.domain.dao;

import java.util.List;

import com.sapient.auction.domain.model.Item;

public interface ItemDao {

	public int createSaleItem(Item item);

	public List<Item> getActiveSaleItems();
	
	public Item getItem(Integer itemId);

}
