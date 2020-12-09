package com.microservice.CarList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarListApplicationTests {

	@Test
	public void contextLoads(){}

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldFindAllCars() throws Exception {
		String cars = restTemplate.getForObject("/models", String.class);
		assertEquals(cars, "[{\"id\":0,\"brand\":\"Clio\",\"color\":\"red\"},{\"id\":1,\"brand\":\"C8\",\"color\":\"black\"},{\"id\":2,\"brand\":\"307\",\"color\":\"blue\"}]");
	}

	@Test
	public void shouldFindOneCarById() throws Exception {
		String cars = restTemplate.getForObject("/models/0", String.class);
		assertEquals(cars, "{\"id\":0,\"brand\":\"Clio\",\"color\":\"red\"}");
	}

}
