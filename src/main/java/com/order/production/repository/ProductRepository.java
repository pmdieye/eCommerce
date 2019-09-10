package com.order.production.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.production.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
