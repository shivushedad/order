package com.pizza.order.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DateUtilTest {

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetUTCTime() {
		Assert.assertNotNull(DateUtil.getUTCTime(1506048176687l));
	}

	@Test
	public void testGetUTCTimeForNull() {
		Assert.assertNull(DateUtil.getUTCTime(null));
	}
}
