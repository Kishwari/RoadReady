/*package com.hexaware.roadready.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.service.IAdminService;


@SpringBootTest
class AdminServiceImplTest {

	Logger logger=LoggerFactory.getLogger(AdminServiceImplTest.class);
	
	@Autowired
	IAdminService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testAddCustomer() {

	}

	@Test
	void testGetCustomerById() {
		CustomerDTO cust=service.getCustomerById(0);
		assertEquals(" ",cust.getFirstName());
		assertNotEquals(" ",cust.getFirstName());
	}

	@Test
	void testGetAllCustomer() {
		List list=service.getAllCustomer();
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testDeleteCustomer() {

	}

	@Test
	void testAddCar() {

	}

	@Test
	void testGetCarById() {
		CarDTO car=service.getCarById(0);
		assertEquals(" ",car.getMake());
		assertNotEquals(" ",car.getMake());
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
	void testViewAllReservations() {
		List list=service.viewAllReservations();
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testViewAllPayments() {
		List list=service.viewAllPayments();
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
		AgentDTO agent=service.getAgentById(0);
		assertEquals("Tommy",agent.getUsername());
		assertNotEquals("smith",agent.getUsername());
	}

	@Test
	void testGetAllAgents() {
		List list=service.getAllAgents();
		boolean flag=list.isEmpty();
		assertFalse(flag);
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

}*/
