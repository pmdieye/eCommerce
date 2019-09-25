package com.order.production.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.order.production.Dto.OrderDto;
import com.order.production.entities.Order;
import com.order.production.entities.Product;
import com.order.production.exception.CommandExistException;
import com.order.production.exception.OrderNotFoundException;
import com.order.production.mapper.OrderMapper;
import com.order.production.repository.OrderRepository;
import com.order.production.repository.ProductRepository;
import com.order.production.service.OrderBo;
@Service
public class OrderImpl implements OrderBo{

	private final OrderRepository orderRepository;
	
	@Autowired
	public  OrderImpl(OrderRepository orderRepository){
		
		this.orderRepository = Objects.requireNonNull(orderRepository);
	}
	@Override
	public void createOrder(OrderDto order) {
		
		Order orderEntity = orderRepository.findByCommandNumber(order.getCommandNumber());
		if(orderEntity != null) {
			throw new CommandExistException(order.getCommandNumber());
		}
		Order orderEnti= OrderMapper.OrderDtoToOrderEntity(order);
		this.orderRepository.save(orderEnti);
	}

	@Override
	public OrderDto findOrder(Long commandNumber) {
		// TODO Auto-generated method stub
		Order orderEntity = orderRepository.findByCommandNumber(commandNumber);
		if(orderEntity==null) {
			throw new OrderNotFoundException(commandNumber);
		}
		OrderDto orderdto = OrderMapper.OrderEntityToOrderDto(orderEntity);
		return orderdto;
	}
	@Override
	public List<OrderDto> listOrder() {
		// TODO Auto-generated method stub
		List<Order> listorder = orderRepository.findAll();
		if(CollectionUtils.isEmpty(listorder)) {
			return new ArrayList<>();
		}
		return listorder.stream()
		.map(order -> OrderMapper.OrderEntityToOrderDto(order))
		.collect(Collectors.toList());
	}
	

}
