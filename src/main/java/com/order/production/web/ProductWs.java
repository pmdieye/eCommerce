package com.order.production.web;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.production.Dto.ProductDto;
import com.order.production.mapper.ProductMapper;
import com.order.production.service.ProductBo;
import com.order.production.ws.in.ProductIn;
import com.order.production.ws.out.ProductOut;

@RestController
@RequestMapping("api")

public class ProductWs {
	@Autowired
	private ProductBo productBo;
	
	@PostMapping("/product")
	public void createProduct(@Valid ProductIn productin) {
		ProductDto productDto = ProductMapper.productInToProductDto(productin);
		this.productBo.createproduct(productDto);	
	}
	
	@GetMapping("/products")
	
	public List<ProductOut> listeProduit(){
		List<ProductDto> listes = productBo.listproduits();
		return listes.stream()
				.map(prod ->ProductMapper.ProductDtoToProductOut(prod))
				.collect(Collectors.toList());
		
	}
	
}
