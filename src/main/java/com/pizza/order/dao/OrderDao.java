package com.pizza.order.dao;

import java.io.IOException;
import java.util.List;

import com.pizza.order.domain.Order;

public interface OrderDao {

	List<Order> scanFile(String inputFile) throws IOException;

	boolean writeData(List<Order> data, String outputFile) throws IOException;
}
