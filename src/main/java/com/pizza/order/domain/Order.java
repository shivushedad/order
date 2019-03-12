package com.pizza.order.domain;

public class Order {
	private String name;
	private Long timeOrdered;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getTimeOrdered() {
		return timeOrdered;
	}
	public void setTimeOrdered(Long timeOrdered) {
		this.timeOrdered = timeOrdered;
	}
}
