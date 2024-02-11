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
import com.hexaware.roadready.exceptions.CarNotFoundException;
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
	void testSearchCars() throws CarNotFoundException {
		List list=service.searchCars("Chennai","Mahindra","Thar");
		boolean flag=list.isEmpty();
		assertFalse(flag);

	}

	@Test
	void testAddCar() {
		CarDTO car=new CarDTO(77,"Hyundai","Creta", "Kolkata", "Maintenance", 4000, "Diesel , Manual", 5);
		Cars e1=service.addCar(car);
		assertNotNull(e1);
		assertEquals(77,e1.getCarId());
		assertTrue(e1.getCarId() >0);
	}

	@Test
	void testGetCarById() throws CarNotFoundException {
		CarDTO car=service.getCarById(55);
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
		int carId=66;
		String result = service.deleteCar(carId);
        assertEquals("car " + carId + " deleted successfully", result);
    }
	

	@Test
	void testUpdateCar() throws CarNotFoundException {
		 CarDTO originalData = new CarDTO(55, "Honda", "City", "Banglore", "Unavailable", 2000, "Petrol, Manual Transmission, AC", 5);
	        CarDTO updatedData = new CarDTO(55, " Honda", "City", "Banglore", "Avialable", 2500, "Petrol, Manual Transmission", 5);
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
