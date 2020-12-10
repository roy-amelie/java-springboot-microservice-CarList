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
	public void shouldFindAllCars() throws Exception {
		String cars = restTemplate.getForObject("/models", String.class);
		assertEquals(cars, "[{\"id\":0,\"brand\":\"Clio\",\"color\":\"red\"},{\"id\":1,\"brand\":\"C8\",\"color\":\"black\"},{\"id\":2,\"brand\":\"307\",\"color\":\"blue\"}]");
	}

	@Test
	public void shouldFindOneCarById() throws Exception {
		String cars = restTemplate.getForObject("/models/0", String.class);
		assertEquals(cars, "{\"id\":0,\"brand\":\"Clio\",\"color\":\"red\"}");
	}

//	@Test
//	public void shouldCreateACar() throws Exception {
//		Car car = new Car(4, "Audi", "purple");
//		restTemplate.postForObject("/models", car, String.class);
//		String cars = restTemplate.getForObject("/models/4", String.class);
//		assertEquals(cars, "{\"id\":4,\"brand\":\"Audi\",\"color\":\"purple\"}");
//	}

	@Test
	public void shouldUpdateACar() throws Exception {
		Car car = new Car(4, "Audi", "purple");
		restTemplate.postForObject("/models", car, String.class);
		car = new Car(4, "Audi", "yellow");
		restTemplate.put("/models/4", car, String.class);
		String cars = restTemplate.getForObject("/models/4", String.class);
		assertEquals(cars, "{\"id\":4,\"brand\":\"Audi\",\"color\":\"yellow\"}");
	}

	@Test
	public void shouldDeleteACar() throws Exception {
		Car car = new Car(4, "Audi", "purple");
		restTemplate.postForObject("/models", car, String.class);
		restTemplate.delete("/models/4", String.class);
		String cars = restTemplate.getForObject("/models/4", String.class);
		assertEquals(cars, null);
	}
}
