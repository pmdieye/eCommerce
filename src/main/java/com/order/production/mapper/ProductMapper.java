package com.order.production.mapper;

import com.order.production.Dto.ProductDto;
import com.order.production.entities.Product;
import com.order.production.ws.in.ProductIn;
import com.order.production.ws.out.ProductOut;

public class ProductMapper {

	public ProductMapper() {
		// TODO Auto-generated constructor stub
	}
	
	public static Product productDtoToProductEntiy(ProductDto productDto) {
		Product product =null;
		if(productDto != null) {
			product= Product.builder()
			.name(productDto.getName())
			.photo(productDto.getPhoto())
			.build();
		}
		return product;
		
	}
	
	public static ProductDto productInToProductDto(ProductIn productIn) {
		ProductDto productDto = null;
		if(productIn  != null) {
			 productDto=ProductDto.builder()
			.name(productIn.getName())
			.photo(productIn.getPhoto()).build();
		}
		return productDto;
		
	}
	
	public static  ProductDto productEntityToProductDto(Product product) {
		ProductDto productDto = null;
		productDto = ProductDto.builder()
				.id(product.getId())
				.name(product.getName())
				.photo(product.getPhoto())
				.build();
		return productDto;
		
	}
	
	public static ProductOut ProductDtoToProductOut(ProductDto productDto) {
		ProductOut productout= null;
		productout= ProductOut.builder()
				.id(productDto.getId())
				.name(productDto.getName())
				.photo(productDto.getPhoto())
				.build();
		return productout;
	}
}
