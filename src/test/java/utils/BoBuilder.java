package utils;

import com.order.production.Dto.OrderDto;

public class BoBuilder {

	public static final OrderDto orderDtoBuilder(Long commandNumber) {
		return OrderDto.builder()
				.commandNumber(commandNumber)
				.build();
		
	}
}
