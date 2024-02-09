package com.hexaware.roadready.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.service.ICarService;

@SpringBootTest
class CarServiceImplTest {

	@Autowired
	ICarService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testGetAvailableCars() {

	}

	@Test
	void testSearchCars() {
		

	}

	@Test
	void testAddCar() {
		CarDTO car=new CarDTO(122,"make","model", "location", "status", 4000, "specification", 0);
		Cars e1=service.addCar(car);
		assertNotNull(e1);
		assertEquals(122,e1.getCarId());
		assertTrue(e1.getCarId() >0);
	}

	@Test
	void testGetCarById() {
		CarDTO car=service.getCarById(101);
		assertEquals("Tommy",car.getMake());
		assertNotEquals("smith",car.getMake());
	}

	@Test
	void testGetAllCars() {
		List list=service.getAllCars();
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testDeleteCar() {

	}

	@Test
	void testUpdateCar() {

	}

	@Test
	void testDiscountOnCarPriceByMake() {

	}

	@Test
	void testUpdateCarPrice() {

	}

}
