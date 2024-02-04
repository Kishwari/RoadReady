package com.hexaware.roadready.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.service.ICustomerService;

@SpringBootTest
class CustomerServiceImplTest {

	Logger logger=LoggerFactory.getLogger(CustomerServiceImplTest.class);

	
	@Autowired
	ICustomerService service;
	
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

	}

	@Test
	void testUpdateCustomer() {

	}

	@Test
	void testMakeReservation() {

	}

	@Test
	void testCancelReservation() {

	}

	@Test
	void testModifyReservation() {

	}

	@Test
	void testProvideFeedback() {

	}

	@Test
	void testViewPaymentHistory() {
		List list=service.viewPaymentHistory(0);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testViewReservations() {
		List list=service.viewReservations(0);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

}
