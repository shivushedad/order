package com.pizza.order;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SortPizzaOrdersAppTest {

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMain() {
		String[] arr = new String[] {"sampleInput.txt", "sampleOutput.txt"};
		SortPizzaOrdersApp.main(arr);
		assertTrue(true);
	}
}
