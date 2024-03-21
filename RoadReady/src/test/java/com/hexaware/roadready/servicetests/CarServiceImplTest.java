package com.hexaware.roadready.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
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
		List list=service.searchCars("Chennai","mahindra","A4");
		boolean flag=list.isEmpty();
		assertTrue(flag);

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
		CarDTO car=service.getCarById(77);
		assertEquals("Hyundai",car.getMake());
		assertNotEquals("Toyota",car.getMake());
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
	void testUpdateCar() {
		    CarDTO originalData = new CarDTO(1005, "Mercedes-Benz", "C-Class", "mumbai", "available", 80, "Automatic transmission, Sunroof , Leather seats", 5);
	        CarDTO updatedData = new CarDTO(1005, "Mercedes-Benz", "C-Class", "mumbai", "available", 80, "Automatic transmission, Sunroof", 5);
	        Cars result = service.updateCar(updatedData);
	        assertEquals(updatedData.getSpecifications(), result.getSpecification());
	        assertNotEquals(originalData.getSpecifications(), result.getSpecification());
	}

	@Test
	void testDiscountOnCarPriceByMake() throws CarNotFoundException {
		List<CarDTO> carDTOList = service.discountOnCarPriceByMake("Audi",10);
		assertNotNull(carDTOList);
		
		
	}

	@Test
	void testUpdateCarPrice() throws CarNotFoundException {
		Cars car=service.updateCarPrice(1006,75);
		assertEquals(75,car.getDailyRate());
	}

}
