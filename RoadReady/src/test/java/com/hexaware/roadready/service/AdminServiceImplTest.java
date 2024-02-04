package com.hexaware.roadready.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;


@SpringBootTest
class AdminServiceImplTest {
    
	@Autowired
	AdminServiceImpl service;
	
	@Test
	void testAddCustomer() {
        CustomerDTO  dto = new CustomerDTO(1, "monica", "geller", "monicageller@gmail.com", "monica@15", "MonicaGeller@1", "9087654321");
        CustomerDTO  dto2=service.addCustomer(dto);
        Customers customer = new Customers();
	    customer.setCustomerId(dto.getCustomerId());
	    customer.setFirstName(dto.getFirstName());
	    customer.setLastName(dto.getLastName());
	    customer.setEmailAddress(dto.getEmailAddress());
	    customer.setUsername(dto.getUsername());
	    customer.setPassword(dto.getPassword());
	    assertNotNull(customer);
        assertEquals(1,customer.getCustomerId());
        assertTrue(customer.getCustomerId()>0);
	}

	@Test
	void testGetCustomerById() {
		CustomerDTO dto = service.getCustomerById(1);
		 Customers customer = new Customers();
		 customer.setFirstName(dto.getFirstName());
		assertEquals("monica",customer.getFirstName());
	}

	@Test
	void testGetAllCustomer() {
		List list = service.getAllCustomer();
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testDeleteCustomer() {
		CustomerDTO dto = new CustomerDTO();
		String statement = service.deleteCustomer(1);
		assertEquals(statement , "record deleted");
		dto=service.getCustomerById(1);
		assertNull(dto);
	}

	@Test
	void testAddCar() {
		CarDTO dto = new CarDTO(101,"honda","honda city", "available", "mumbai", 200, "Displacement: 1.5 liters ", 5);
		CarDTO dto2 = service.addCar(dto);

		Cars car = new Cars();
		car.setCarId(dto.getCarId());
		car.setMake(dto.getMake());
		car.setModel(dto.getModel());
		car.setCarStatus(dto.getCarStatus());
		car.setLocation(dto.getLocation());
		car.setDailyRate(dto.getDailyRate());
		car.setSpecification(dto.getSpecifications());
        car.setPassengerCapacity(dto.getPassengerCapacity());
		assertNotNull(car);
		assertEquals(101, car.getCarId());
		assertTrue(car.getCarId() > 0);

	}

	@Test
	void testGetCarById() {
		 CarDTO dto = service.getCarById(101);
		 Cars car = new Cars();
		 car.setMake(dto.getMake());
		 assertEquals("Honda",car.getMake());
	}

	@Test
	void testGetAllCars() {
		List list = service.getAllCars();
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testDeleteCar() {
		CarDTO dto = new CarDTO();
		String statement = service.deleteCustomer(1);
		assertEquals(statement , "required car/cars deleted");
		dto=service.getCarById(101);
		assertNull(dto);
	}

	@Test
	void testUpdateCar() {
		CarDTO dto = new CarDTO(101,"honda","honda city", "available", "mumbai", 200, "Displacement: 1.5 liters ", 4);
		CarDTO dto2 = service.addCar(dto);

		Cars car = new Cars();
		car.setCarId(dto.getCarId());
		car.setMake(dto.getMake());
		car.setModel(dto.getModel());
		car.setCarStatus(dto.getCarStatus());
		car.setLocation(dto.getLocation());
		car.setDailyRate(dto.getDailyRate());
		car.setSpecification(dto.getSpecifications());
        car.setPassengerCapacity(dto.getPassengerCapacity());
		assertNotNull(car);
		assertEquals(4, car.getPassengerCapacity());
		
        
	}

	@Test
	void testViewAllReservations() {
		List list = service.viewAllReservations();
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testViewAllPayments() {
		List list = service.viewAllPayments();
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testDiscountOnCarPrice() {
		
	}

	@Test
	void testUpdateCarPrice() {
		
	}

	@Test
	void testGiveFeedback() {
		
	}

	@Test
	void testAddAgent() {
		
	}

	@Test
	void testGetAgentById() {
		
	}

	@Test
	void testGetAllAgents() {
		
	}

	@Test
	void testDeleteAgent() {
		
	}

	@Test
	void testGetPaymentDetailsForCustomer() {
		
	}

	@Test
	void testGetReservationDetailsForCustomer() {
		
	}

}
