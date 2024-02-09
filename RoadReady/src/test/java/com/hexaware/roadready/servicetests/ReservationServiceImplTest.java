package com.hexaware.roadready.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.service.IReservationService;

@SpringBootTest
class ReservationServiceImplTest {

	@Autowired
	IReservationService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testViewAllReservations() {
		List list=service.viewAllReservations();
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testCancelReservation() {

	}

	@Test
	void testModifyReservation() {
		

	}

	@Test
	void testViewReservations() {
		List list=service.viewReservations(101);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testGetReservationDetailsForCustomer() {
		List list=service.getReservationDetailsForCustomer(101);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

}
