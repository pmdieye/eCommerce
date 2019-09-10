package com.order.production.Dto;

import java.util.Date;
import java.util.List;

import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.order.production.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@ToString(exclude = {"listeproduits"})
@AllArgsConstructor
@Builder
public class OrderDto {
	private Long commandNumber;
	@CreationTimestamp
	private Date creationDate;
	@UpdateTimestamp
	private Date modificationDate;
	@OneToMany(mappedBy="order")
	private List<Product> listeproduits;

}
