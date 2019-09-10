package utils;

import com.order.production.entities.Order;

public class EntitiesBuilder {
	
	public EntitiesBuilder() {
		// TODO Auto-generated constructor stub
	}
	public static  Order orderEntityBuilder(Long commandNumber ) {
		return Order.builder()
				.commandNumber(commandNumber)
				.build();
				
	}
}
