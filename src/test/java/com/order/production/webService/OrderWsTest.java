package com.order.production.webService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.order.production.Dto.OrderDto;
import com.order.production.service.OrderBo;
import com.order.production.web.OrderWS;

import junit.framework.TestCase;
import utils.BoBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderWS.class)
public class OrderWsTest extends TestCase{
 
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OrderBo orderBo;
	@Test
	public void testFindorder() throws Exception{
		OrderDto orderDto = BoBuilder.orderDtoBuilder(10L);
		
		when(orderBo.findOrder(10L)).thenReturn(orderDto);
		
		ResultActions result = this.mockMvc.perform(get("/api/order/10"));
		
		verify(orderBo).findOrder(10L);
		
		result.andExpect(status().isOk());
		result.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		result.andExpect(content().json("{\n" + 
				"  \"commandNumber\": 10,\n" + 
				"  \"creationDate\": null,\n" + 
				"  \"modificationDate\": null \n" + 
				"}", true));
		
	}
}
