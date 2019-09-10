package com.order.production.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.order.production.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	Order findByCommandNumber(@Param("commandNumber")Long commandNumber);

}
