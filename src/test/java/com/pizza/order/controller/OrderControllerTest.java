package com.pizza.order.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.pizza.order.domain.Order;
import com.pizza.order.service.OrderService;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@InjectMocks
	private OrderController orderController = new OrderController();

	@Mock
	private OrderService orderService;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testReadData() throws Exception {
		Mockito.when(orderService.readData(Matchers.anyString())).thenReturn(getData());
		Mockito.when(orderService.sortData(Matchers.anyList())).thenReturn(getData());
		Assert.assertEquals(orderController.processInputFile(Matchers.anyString()).size(), 1);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testReadDataWithNullData() throws Exception {
		Mockito.when(orderService.readData(Matchers.anyString())).thenReturn(null);
		Mockito.when(orderService.sortData(Matchers.anyList())).thenReturn(null);
		Assert.assertNull(orderController.processInputFile(Matchers.anyString()));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testWriteData() throws Exception {
		Mockito.when(
				orderService.writeData(Matchers.any(ArrayList.class),
						Matchers.anyString())).thenReturn(true);
		Assert.assertTrue(orderController.writeData(getData(), "test.txt"));
	}

	private ArrayList<Order> getData() {
		ArrayList<Order> orderList = new ArrayList<>();
		Order order = new Order();
		order.setName("Test1");
		order.setTimeOrdered(1223432l);
		orderList.add(order);
		return orderList;
	}
}
