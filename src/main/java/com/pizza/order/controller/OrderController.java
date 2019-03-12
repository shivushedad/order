package com.pizza.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pizza.order.domain.Order;
import com.pizza.order.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	public List<Order> processInputFile(String inputFile) throws Exception {
		List<Order> unorderedList = orderService.readData(inputFile);
		return orderService.sortData(unorderedList);
	}
	
	public boolean writeData(List<Order> data, String outputFile) throws Exception {
		return orderService.writeData(data, outputFile);
	}
}
