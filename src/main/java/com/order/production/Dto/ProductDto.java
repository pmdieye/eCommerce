package com.order.production.Dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.order.production.entities.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
	@NotNull
	private Long id;
	@NotNull
	private String name;
	private String photo;
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

}
