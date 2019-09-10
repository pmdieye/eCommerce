package com.order.production.mapper;

import org.junit.Test;

import com.order.production.Dto.OrderDto;
import com.order.production.entities.Order;

import junit.framework.TestCase;
import utils.BoBuilder;
import utils.EntitiesBuilder;

public class OrderMapperTest extends TestCase{
	
	@Test
	public void testOrderEntityToOrderDto() {
		Order order = EntitiesBuilder.orderEntityBuilder(10L);
		
		OrderDto result = OrderMapper.OrderEntityToOrderDto(order);
		
		assertNotNull(result);
		assertEquals(order.getCommandNumber(), result.getCommandNumber());
	}
	@Test
	public void testOrderentityNullToOrderDto() {
		OrderDto result = OrderMapper.OrderEntityToOrderDto(null);
		assertNull(result);
		
	}
	
	@Test
	public void testOrderDtoToOrderEntity() {
		OrderDto orderDto = BoBuilder.orderDtoBuilder(10L);
		
		Order result = OrderMapper.OrderDtoToOrderEntity(orderDto);
		
		assertNotNull(result);
		assertEquals(orderDto.getCommandNumber(), result.getCommandNumber());
	}

}
