package com.sapient.auction.services.impl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.sapient.auction.domain.dao.ItemDao;
import com.sapient.auction.domain.model.Item;
import com.sapient.auction.exception.ServiceException;

@RunWith(PowerMockRunner.class)
public class ItemServiceImplTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImplTest.class);

	@Mock
	ItemDao itemDao;
	@Mock
	MultipartFile file;

	@InjectMocks
	ItemServiceImpl itemService = new ItemServiceImpl();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public final void testCreateSaleItem_Success() throws IOException, ServiceException {

		Item item = new Item();
		when(file.getBytes()).thenReturn("abc".getBytes());
		item.setFile(file);
		when(itemDao.createSaleItem(item)).thenReturn(1);

		int result = itemService.createSaleItem(item);

		Assert.assertEquals(1, result);
		Assert.assertEquals(new Date().toString(), item.getCreateDateTime().toString());
		Mockito.verify(itemDao, times(1)).createSaleItem(item);
	}

	@Test
	public final void testCreateSaleItem_Failure() throws IOException {

		Item item = new Item();
		when(file.getBytes()).thenThrow(IOException.class);

		item.setFile(file);
		when(itemDao.createSaleItem(item)).thenReturn(1);
		try {
			itemService.createSaleItem(item);
			Assert.assertTrue(false);
		} catch (ServiceException e) {
			Assert.assertTrue(true);
			LOGGER.error("Exception while testCreateSaleItem_Failure", e);
		}

	}

	@Test
	public final void testGetActiveSaleItems_ReturnsItems() throws Exception {

		Item item = new Item();
		item.setImageByteArray("abc".getBytes());
		item.setItemId(10);
		List<Item> items = new ArrayList<>();
		items.add(item);
		when(itemDao.getActiveSaleItems()).thenReturn(items);
		List<Item> result = itemService.getActiveSaleItems();
		Assert.assertEquals(1, result.size());
		verify(itemDao).getActiveSaleItems();
	}

	@Test
	public final void testGetActiveSaleItems_NoItems() {

		when(itemDao.getActiveSaleItems()).thenReturn(null);
		try {
			itemService.getActiveSaleItems();
			Assert.assertTrue(false);
		} catch (ServiceException e) {
			Assert.assertTrue(true);
			LOGGER.error("Exception while testGetActiveSaleItems_NoItems", e);
		}
	}

	@Test
	public final void testGetItem() {

		Item item = new Item();
		item.setImageByteArray("abc".getBytes());
		item.setItemId(10);
		when(itemDao.getItem(10)).thenReturn(item);
		itemService.getItem(10);
		verify(itemDao).getItem(10);
	}
}
