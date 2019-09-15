package com.order.production.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.order.production.Dto.OrderDto;
import com.order.production.entities.Order;
import com.order.production.exception.OrderNotFoundException;
import com.order.production.repository.OrderRepository;
import com.order.production.service.serviceImpl.OrderImpl;

import junit.framework.TestCase;
import utils.EntitiesBuilder;

@RunWith(MockitoJUnitRunner.class)
public class OrderSeviceImpl extends TestCase {

	@InjectMocks
	private OrderImpl orderService;

	@Mock
	private OrderRepository orderRepository;

	@Test(expected = OrderNotFoundException.class)
	public void testFindOrderNotExist() {

		when(orderRepository.findByCommandNumber(10L)).thenReturn(null);

		OrderDto result = orderService.findOrder(10L);
		verify(orderRepository).findByCommandNumber(10L);
		assertNull(result);

	}

	@Test
	public void testFindOrderExist() {

		com.order.production.entities.Order order1 = EntitiesBuilder.orderEntityBuilder(10L);

		when(orderRepository.findByCommandNumber(10L)).thenReturn(order1);

		OrderDto result = orderService.findOrder(10L);
		verify(orderRepository).findByCommandNumber(10L);
		assertNotNull(result);

	}
	@Test
	public void testFindAllorder() {
		com.order.production.entities.Order order1 = EntitiesBuilder.orderEntityBuilder(10L);
		com.order.production.entities.Order order2 = EntitiesBuilder.orderEntityBuilder(1L);
		List<Order> orders = Arrays.asList(order1,order2);
		when(orderRepository.findAll()).thenReturn(orders);
		
		List<OrderDto> orderdtos= orderService.listOrder();
		
		assertEquals(2, orderdtos.size());
		verify(orderRepository,times(1)).findAll();
	}

}
