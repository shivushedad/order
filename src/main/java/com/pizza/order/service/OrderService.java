package com.pizza.order.service;

import java.io.IOException;
import java.util.List;

import com.pizza.order.domain.Order;

public interface OrderService {
	
	List<Order> readData(String inputFile) throws IOException;
	
	public List<Order> sortData(List<Order> input);

	boolean writeData(List<Order> data,String outputFile) throws IOException;
}
