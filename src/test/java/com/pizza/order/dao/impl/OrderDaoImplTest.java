package com.pizza.order.dao.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import com.pizza.order.dao.OrderDao;
import com.pizza.order.domain.Order;

@RunWith(MockitoJUnitRunner.class)
public class OrderDaoImplTest {

	@InjectMocks
	private OrderDao orderDao = new OrderDaoImpl();

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testReadData() throws IOException {
		Assert.assertNotNull(orderDao.scanFile("sampleInput.txt"));
	}

	@Test
	public void testWriteData() throws IOException {
		Assert.assertSame(true, orderDao.writeData(getData(), "sampleOutput.txt"));
	}

	private ArrayList<Order> getData() {
		ArrayList<Order> orderList = new ArrayList<>();
		Order orderBean = new Order();
		orderBean.setName("Test1");
		orderBean.setTimeOrdered(Long.valueOf(1223432));
		orderList.add(orderBean);
		return orderList;
	}
}
