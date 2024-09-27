package com.order.production.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.production.Dto.OrderDto;
import com.order.production.mapper.OrderMapper;
import com.order.production.service.OrderBo;
import com.order.production.ws.in.OrderIn;
import com.order.production.ws.out.OrderOut;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
public class OrderWS {
	
	@Autowired
	private OrderBo orderBo;
	
	@PostMapping("/order")
	@ApiOperation("create  an order if not exit yet")
	public void createOrder(@RequestBody @Valid OrderIn orderIn) {
		
		OrderDto orderDto = OrderMapper.OrderInToOrderDto(orderIn);
		orderBo.createOrder(orderDto);
	}
	
	@GetMapping("/order/{commandNumber}")
	@ApiOperation("Find order by commandNumber")
	public OrderOut findOrder(@PathVariable Long commandNumber) {
		OrderDto orderDto = orderBo.findOrder(commandNumber);
		return OrderMapper.orderDtoToOrderOut(orderDto);
		
	}
	
	@GetMapping("/orders")
	@ApiOperation("Find list orders")
	public List<OrderOut> findList() {
		List<OrderDto> listOrderDto = orderBo.listOrder();
		return listOrderDto.stream()
				.map(orderDto -> OrderMapper.orderDtoToOrderOut(orderDto))
				.collect(Collectors.toList());
		
	}

}
