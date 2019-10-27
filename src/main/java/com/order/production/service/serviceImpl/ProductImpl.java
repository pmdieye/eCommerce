package com.order.production.service.serviceImpl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.order.production.Dto.ProductDto;
import com.order.production.entities.Product;
import com.order.production.exception.ProductAlreadyExistException;
import com.order.production.exception.ProductNotFoundException;
import com.order.production.mapper.ProductMapper;
import com.order.production.repository.OrderRepository;
import com.order.production.repository.ProductRepository;
import com.order.production.service.ProductBo;

@Service
public class ProductImpl implements ProductBo{
	
	private final ProductRepository productRepository;
	
	private final OrderRepository orderRepository;
	
	public ProductImpl(ProductRepository productRepository,OrderRepository orderRepository) {
		
		this.orderRepository =Objects.requireNonNull(orderRepository);
		this.productRepository =Objects.requireNonNull(productRepository);

	}

	@Override
	public void createproduct(ProductDto productDto) {
		
		Product product = productRepository.findByName(productDto.getName());
		if(product!= null) {
			throw new ProductAlreadyExistException(productDto.getName());
		}
		Product productEntity = ProductMapper.productDtoToProductEntiy(productDto);
		productRepository.save(productEntity);
	}

	@Override
	public Product findProduct(Long product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> listproduits() {
		List<Product> liste = this.productRepository.findAll();
		if (CollectionUtils.isEmpty(liste)) {
			return new ArrayList<>();
		}
		return liste.stream()
			.map(product -> ProductMapper.productEntityToProductDto(product))
			.collect(Collectors.toList());
			
	}

	@Override
	public byte[] getPhoto(Long id) throws IOException {
		Product p = productRepository.findById(id).get();
		return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/images/"+p.getPhoto()));
		
	}

	@Override
	public void editPhoto(MultipartFile file, Long id) throws IOException {
		// TODO Auto-generated method stub
		Product p = productRepository.findById(id).get();
		if(p==null) {
			throw new ProductNotFoundException(p.getName());
		}
		p.setPhoto(id+".jpg");
		Path path = Paths.get(System.getProperty("user.home")+"/ecom/images/"+p.getPhoto());
		//Files.write(Paths.get(System.getProperty("user.home")+"/ecom/images/"+p.getPhoto()), file.getBytes());
		file.transferTo(path);
		productRepository.save(p);
	}
	
	

}
