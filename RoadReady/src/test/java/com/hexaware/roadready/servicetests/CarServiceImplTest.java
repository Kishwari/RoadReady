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
		List list=service.getAvailableCars();
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testSearchCars() {
		List list=service.searchCars("location","make","model");
		boolean flag=list.isEmpty();
		assertFalse(flag);

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
		int carId=101;
		String result = service.deleteCar(carId);
        assertEquals("car " + carId + " deleted successfully", result);
    }
	

	@Test
	void testUpdateCar() {
		 CarDTO originalData = new CarDTO(1, "John Doe", "model", "location", "status", 30, "specification", 0);
	        CarDTO updatedData = new CarDTO(1, "Jane Doe", null, null, null, 35, null, 0);
	        Cars result = service.updateCar(originalData);
	        assertEquals(updatedData, result);
	}

	@Test
	void testDiscountOnCarPriceByMake() {

	}

	@Test
	void testUpdateCarPrice() {

	}

}
