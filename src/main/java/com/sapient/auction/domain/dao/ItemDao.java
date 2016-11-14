package com.sapient.auction.domain.dao;

import com.sapient.auction.domain.model.Item;

public interface ItemDao {

	public int createSaleItem(Item item) throws RuntimeException;

}
