package com.order.production.it;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import io.restassured.RestAssured;


@Sql({"classpath:it/schema.sql", "classpath:it/data_order.sql"})
public class OrderIt {
	
	private static final Long COMMAND_NUMBER = 10L;
	private static final String DEVICE_BASE_URL = "localhost:8081";
	private static final String GET_ORDER_URL = "/api/order/10";

	@Test
	public void testFindOrderBycommandNumber() {
		RestAssured
				.given()
					.param("deviceNumber",COMMAND_NUMBER)
				.when()
					.get(DEVICE_BASE_URL + GET_ORDER_URL)
				.then()
					.statusCode(HttpStatus.OK.value())
					.body("commandNumber", Matchers.is(10L))
		;
	}

}
