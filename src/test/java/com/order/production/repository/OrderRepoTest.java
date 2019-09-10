package com.order.production.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.order.production.entities.Order;
import com.order.production.repository.OrderRepository;

import junit.framework.TestCase;
import utils.EntitiesBuilder;

@DataJpaTest
@RunWith(SpringRunner.class)
public class OrderRepoTest extends TestCase {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void findOrderTest(){
		Order orderEntity = EntitiesBuilder.orderEntityBuilder(10l);
		entityManager.persist(orderEntity);
		entityManager.flush();
		entityManager.clear();
		
		Order result = orderRepository.findByCommandNumber(10L);
		assertNotNull(result);
		assertEquals(orderEntity.getCommandNumber(), result.getCommandNumber());
		
	}
	
	@Test
	public void testCreateOrder() {
		Order orderEntity = EntitiesBuilder.orderEntityBuilder(10l);
		orderRepository.save(orderEntity);
		
		Order result = (Order) entityManager.getEntityManager()
				.createQuery("from Order where commandNumber = :param")
				.setParameter("param", 10l).getSingleResult();
		assertEquals(orderEntity, result);

		
	}
	

	
	

}
