package com.order.production.service;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.order.production.Dto.ProductDto;
import com.order.production.entities.Product;

public interface ProductBo {
	
	void createproduct(ProductDto product);
	Product findProduct(Long idProd);
	List<ProductDto> listproduits();
	public byte[] getPhoto(Long id) throws IOException;
	public void editPhoto(MultipartFile file,Long id) throws IOException;
}
