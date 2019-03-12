package com.pizza.order.service.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.pizza.order.dao.OrderDao;
import com.pizza.order.domain.Order;
import com.pizza.order.service.OrderService;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

	@InjectMocks
	private OrderService orderService = new OrderServiceImpl();

	@Mock
	private OrderDao orderDao;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testReadData() throws IOException {
		Mockito.when(orderDao.scanFile(Matchers.anyString())).thenReturn(getData());
		Assert.assertTrue(orderService.readData(Matchers.anyString()).size() == 1);
	}

	@Test
	public void testscanFileWithNullData() throws IOException {
		Mockito.when(orderDao.scanFile(Matchers.anyString())).thenReturn(null);
		Assert.assertNull(orderService.readData(Matchers.anyString()));
	}

	@Test
	public void testWriteData() throws IOException {
		Mockito.when(orderDao.writeData(Matchers.any(ArrayList.class), Matchers.anyString())).thenReturn(true);
		Assert.assertTrue(orderService.writeData(getData(), "test.txt"));
	}

	private ArrayList<Order> getData() {
		ArrayList<Order> orderList = new ArrayList<>();
		Order order = new Order();
		order.setName("Test1");
		order.setTimeOrdered(1654987654321l);
		orderList.add(order);
		return orderList;
	}
}
