package com.sapient.auction.services;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

import com.sapient.auction.dao.exception.ServiceException;
import com.sapient.auction.domain.dao.ItemDao;
import com.sapient.auction.domain.model.Item;

@RunWith(PowerMockRunner.class)
public class ItemServiceImplTest {

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
		when(itemDao.createSaleItem(Mockito.any(Item.class))).thenReturn(10);
		Assert.assertEquals(10, itemService.createSaleItem(item));
		Mockito.verify(itemDao, times(1)).createSaleItem(item);
	}

	@Test
	public final void testCreateSaleItem_Failure() throws IOException, ServiceException {

		Item item = new Item();
		when(file.getBytes()).thenReturn("abc".getBytes());
		item.setFile(file);
		when(itemDao.createSaleItem(Mockito.any(Item.class))).thenReturn(0);
		Assert.assertNotEquals(10, itemService.createSaleItem(item));
		Mockito.verify(itemDao, times(1)).createSaleItem(item);
	}

	@Test
	public final void testGetActiveSaleItems_ReturnsItems() throws Exception {

		Item item = new Item();
		item.setImageByteArray("abc".getBytes());
		item.setItemId(10);
		List<Item> items = new ArrayList<>();
		items.add(item);
		when(itemDao.getActiveSaleItems()).thenReturn(items);

		Assert.assertEquals(1, itemService.getActiveSaleItems().size());
		verifyPrivate(itemService).invoke("convertToBase64Encoded", "abc".getBytes());

	}

	@Test
	public final void testGetActiveSaleItems_NoItems() {

		Item item = new Item();
		item.setImageByteArray("abc".getBytes());
		item.setItemId(10);
		List<Item> items = new ArrayList<>();
		items.add(item);
		when(itemDao.getActiveSaleItems()).thenReturn(items);

		Assert.assertEquals(1, itemService.getActiveSaleItems().size());
		Mockito.verify(itemDao, times(1)).getActiveSaleItems();

	}

	@Test
	public final void testGetItem() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetItemDao() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetItemDao() {
		fail("Not yet implemented"); // TODO
	}

}
