package com.order.production.service;

import java.util.List;

import com.order.production.Dto.ProductDto;
import com.order.production.entities.Product;

public interface ProductBo {
	
	void createproduct(ProductDto product);
	Product findProduct(Long idProd);
	List<ProductDto> listproduits();

}
