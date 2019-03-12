package com.pizza.order;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pizza.order.controller.OrderControllerTest;
import com.pizza.order.dao.impl.OrderDaoImplTest;
import com.pizza.order.domain.OrderTest;
import com.pizza.order.service.impl.OrderServiceImplTest;
import com.pizza.order.util.DateUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ OrderControllerTest.class, OrderServiceImplTest.class,
		OrderDaoImplTest.class, OrderTest.class, DateUtilTest.class })
public class RunAllTests {

}
