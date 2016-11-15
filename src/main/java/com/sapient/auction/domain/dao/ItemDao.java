package com.sapient.auction.domain.dao;

import java.util.List;

import com.sapient.auction.domain.model.Item;

public interface ItemDao {

	public int createSaleItem(Item item) throws RuntimeException;

	public List<Item> getActiveSaleItems() throws RuntimeException;

}
