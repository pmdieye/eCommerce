package com.order.production.mapper;

import com.order.production.Dto.OrderDto;
import com.order.production.entities.Order;
import com.order.production.ws.in.OrderIn;
import com.order.production.ws.out.OrderOut;

public final class OrderMapper {
	public OrderMapper() {
		// TODO Auto-generated constructor stub
	}
	
	public static OrderDto OrderEntityToOrderDto(Order order){
		
		OrderDto orderDto =null;
		if(order != null) {
			orderDto = new OrderDto();
			orderDto.setCommandNumber(order.getCommandNumber());
			orderDto.setCreationDate(order.getCreationDate());
			orderDto.setModificationDate(order.getModificationDate());
		}
		return orderDto;
	}
	
	public static Order OrderDtoToOrderEntity(OrderDto orderDto) {
		Order order =null;
		if(orderDto != null) {
			order = new Order();
			order.setCommandNumber(orderDto.getCommandNumber());
			order.setCreationDate(orderDto.getCreationDate());
			order.setModificationDate(orderDto.getModificationDate());
		}
		return order;
	}
	
	public static OrderDto OrderInToOrderDto(OrderIn orderIn) {
		OrderDto orderDto = null;
		if(orderIn != null) {
			orderDto = new OrderDto();
			orderDto.setCommandNumber(orderIn.getCommandNumber());
			orderDto.setCreationDate(orderIn.getCreationDate());
			orderDto.setModificationDate(orderIn.getCreationDate());
		}
		return orderDto;
	}
	public static OrderOut orderDtoToOrderOut(OrderDto orderDto) {
		OrderOut orderOut = null;
		if(orderDto != null) {
			orderOut = new OrderOut();
			orderOut.setCommandNumber(orderDto.getCommandNumber());
			orderOut.setCreationDate(orderDto.getCreationDate());
			orderOut.setModificationDate(orderDto.getModificationDate());
		}
		return orderOut;
	}
	

}
