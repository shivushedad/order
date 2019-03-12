package com.pizza.order.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pizza.order.constants.Constants;
import com.pizza.order.dao.OrderDao;
import com.pizza.order.domain.Order;
import com.pizza.order.util.DateUtil;


@Repository
public class OrderDaoImpl implements OrderDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderDaoImpl.class);

	@Override
	public List<Order> scanFile(String inputFile) throws IOException {
		List<Order> orderList = new ArrayList<>();

		try (
			FileReader fr = new FileReader(new File(inputFile));
			BufferedReader	br = new BufferedReader(fr);
		) {	
			String orderStr = br.readLine();
			while ((orderStr = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(orderStr, "\t");
				while (st.hasMoreTokens()) {
					Order order = new Order();
					order.setName(st.nextToken());
					order.setTimeOrdered(Long.valueOf(st.nextToken()));
					orderList.add(order);
				}
			}
		} catch (IOException e) {
			LOGGER.error("Error: "+Constants.FILE_NOT_FOUND + e.getMessage(), e);
			throw e;
		}

		return orderList;
	}
	
	/**
	 * Write the data to destination file.
	 */
	@Override
	public boolean writeData(List<Order> data, String outputFile) throws IOException {
		File file = new File(outputFile);
		boolean flag = false;
		int rowNo = 0;
		try (
			FileOutputStream fout = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));
		) {
			if (!file.exists() && !file.createNewFile()) {
				return false;
			}
			StringBuilder output = new StringBuilder();
			output.append(getHeader()).append("\n");
			
			bw.write(getHeader());
			bw.newLine();
			for (Order order : data) {
				String line = String.format("%-6d\t%-10s\t%-15s", ++rowNo, 
							order.getName(),
							DateUtil.getUTCTime(order.getTimeOrdered() * 1000));
				bw.write(line);
				bw.newLine();
			}
			bw.flush();
			flag = true;
		} catch (IOException e) {
			LOGGER.error("Error:" + e.getMessage(), e);
			throw e;
		}

		return flag;
	}

	private String getHeader() {
		return String.format("%6s\t%10s\t%15s", Constants.ORDER_NO,
				Constants.ORDER_NAME, Constants.ORDER_TIME);
	}
}
