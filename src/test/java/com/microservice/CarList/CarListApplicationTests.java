package com.microservice.CarList;
import com.microservice.CarList.model.Car;
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
	public void shouldReturnEmptyList() throws Exception {
		String cars = restTemplate.getForObject("/models", String.class);
		assertEquals(cars, "[]");
	}

	@Test
	public void shouldCreateACar() throws Exception {
		Car car = new Car(  "Audi", "purple");
		restTemplate.postForObject("/models", car, String.class);
		String cars = restTemplate.getForObject("/models", String.class);
		assertEquals(cars, "[{\"id\":1,\"brand\":\"Audi\",\"color\":\"purple\"}]");
	}

	@Test
	public void shouldFindOneCarById() throws Exception {
		String cars = restTemplate.getForObject("/models/1", String.class);
		assertEquals(cars, "{\"id\":1,\"brand\":\"Audi\",\"color\":\"purple\"}");
	}

	@Test
	public void shouldUpdateACar() throws Exception {
		Car car = new Car(1, "Audi", "yellow");
		restTemplate.put("/models/1", car, String.class);
		String cars = restTemplate.getForObject("/models/1", String.class);
		assertEquals(cars, "{\"id\":1,\"brand\":\"Audi\",\"color\":\"yellow\"}");
	}

	@Test
	public void shouldDeleteACar() throws Exception {
		restTemplate.delete("/models/1", String.class);
		String cars = restTemplate.getForObject("/models", String.class);
		assertEquals(cars, "[]");
	}
}
