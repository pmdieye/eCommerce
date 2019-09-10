package com.order.production.ws.in;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderIn {
	
	@NotNull
	private Long commandNumber;
	
	@NotNull
	private Date creationDate;
	
	private Date modificationDate;

}
