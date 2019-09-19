package com.order.production.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.order.production.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findByName(@Param("name")String name);

}
