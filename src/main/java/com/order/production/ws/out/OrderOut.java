package com.order.production.ws.out;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderOut {
	
	private Long commandNumber;
	
	private Date creationDate;
	
	private Date modificationDate;
}
