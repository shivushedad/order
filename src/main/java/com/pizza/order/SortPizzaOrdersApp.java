package com.pizza.order;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.pizza.order.constants.Constants;
import com.pizza.order.controller.OrderController;
import com.pizza.order.domain.Order;

@SpringBootApplication
public class SortPizzaOrdersApp {

	private static final Logger LOGGER = LoggerFactory.getLogger(SortPizzaOrdersApp.class);
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SortPizzaOrdersApp.class, args);
		try {
			if (args.length == 3) {
				OrderController orderController = applicationContext.getBean(OrderController.class);
				List<Order> data = orderController.processInputFile(args[1]);
				boolean flag = orderController.writeData(data, args[2]);
				if (flag) {
					LOGGER.debug(Constants.FILE_GENERATED);
				}
			} else {
				LOGGER.info("\n\t\t\t\t\t------------------------------------------------------------------------------------------------------------------------------");
				LOGGER.info("USAGE: java -jar target\\SortPizzaOrders-0.0.1-SNAPSHOT.jar com.pizza.order.SortPizzaOrderApp <input File> <output File> <enter>");
				LOGGER.info("\n\t\t\t\t\t------------------------------------------------------------------------------------------------------------------------------");
			}
		} catch (Exception e) {
			LOGGER.error("Error processing the input file: " + e.getMessage(), e);
		}
	}
}
