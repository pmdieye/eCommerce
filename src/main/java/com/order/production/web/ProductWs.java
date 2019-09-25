package com.order.production.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.order.production.Dto.ProductDto;
import com.order.production.mapper.ProductMapper;
import com.order.production.service.ProductBo;
import com.order.production.ws.in.ProductIn;
import com.order.production.ws.out.ProductOut;


@RestController
@RequestMapping("api")
@CrossOrigin("*")
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
	
	@GetMapping(path="/photos/{id}",produces=MediaType.IMAGE_PNG_VALUE)
	public byte[] getPhotoProduct(@PathVariable Long id) throws IOException {
		return productBo.getPhoto(id);
	}
	
	@PostMapping(path="/uploadphoto/{id}")
	public void uploadPhoto(MultipartFile file,@PathVariable Long id) throws IOException {
		this.productBo.editPhoto(file, id);
		
	}

}
