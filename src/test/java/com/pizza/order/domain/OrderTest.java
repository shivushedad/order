package com.pizza.order.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {
	
	private Order order;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		order = getOrder();
	}

	@Test
	public void testGetOrderName() {
		Assert.assertTrue(order.getName().equals("test"));
	}

	@Test
	public void testSetOrderName() {
		order.setName("test");
		Assert.assertTrue(order.getName().equals("test"));
	}

	@Test
	public void testGetOrderTime() {
		Assert.assertTrue(order.getTimeOrdered() == 12345);
	}

	@Test
	public void testSetOrderTime() {
		order.setTimeOrdered(Long.valueOf(1234));
		Assert.assertFalse(order.getTimeOrdered() == 12345);
	}

	/*@Test
	public void testCompareTo() {
		Order Order = getOrder();
		Order.setTimeOrdered(Long.valueOf(1234));
		Assert.assertSame(0, Order.compareTo(Order));
	}*/

	private Order getOrder() {
		Order Order = new Order();
		Order.setName("test");
		Order.setTimeOrdered(Long.valueOf(12345));
		return Order;
	}
}
