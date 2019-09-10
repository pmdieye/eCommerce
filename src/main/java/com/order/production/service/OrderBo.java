package com.order.production.service;

import java.util.List;

import com.order.production.Dto.OrderDto;
import com.order.production.entities.Order;

public interface OrderBo {
	
	void createOrder(OrderDto order);
	OrderDto findOrder(Long commandNumber);
	List<OrderDto> listOrder();

}
