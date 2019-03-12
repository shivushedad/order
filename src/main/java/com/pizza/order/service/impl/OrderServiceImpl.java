package com.pizza.order.service.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.order.dao.OrderDao;
import com.pizza.order.domain.Order;
import com.pizza.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;

	@Override
	public List<Order> readData(String inputFile) throws IOException {
		return orderDao.scanFile(inputFile);
	}
	
	@Override
	public List<Order> sortData(List<Order> input) {
		Collections.sort(input, new Comparator<Order>() {
			@Override
			public int compare(Order o1, Order o2) {
				if (o1.getTimeOrdered() < o2.getTimeOrdered()) {
					return -1;
				}
				return 0;
			}
		});
		return input;
	}

	@Override
	public boolean writeData(List<Order> data, String outputFile) throws IOException {
		return orderDao.writeData(data, outputFile);
	}
}
