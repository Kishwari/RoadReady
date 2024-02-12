package com.hexaware.roadready.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.exceptions.ReservationNotFoundException;
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
		int reservationId=3003;
		String result = service.cancelReservation(reservationId);
        assertEquals("your reservation " + reservationId +" cancelled successfully", result);
	}

	@Test
	void testModifyReservation() throws ReservationNotFoundException {
		int reservationId = 3000;
	        LocalDate dateOfPickup = LocalDate.of(2024, 2, 12);
	       LocalDate dateOfDropoff = LocalDate.of(2024, 3, 12);
		  // ReservationDTO originalData = new ReservationDTO(3000,"reserved",LocalDate.now(),LocalDate.of(2024, 3, 3),LocalDate.of(2024, 4, 4));
		  ReservationDTO expectedData = new ReservationDTO(3000,"reserved",LocalDate.of(2024, 2, 12),dateOfPickup,dateOfDropoff);
		 ReservationDTO result = service.modifyReservation(reservationId, dateOfPickup, dateOfDropoff);
	        assertEquals(expectedData, result);

	}

	@Test
	void testViewReservations() {
		List list=service.viewReservations(2);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testGetReservationDetailsForCustomer() {
		List list=service.getReservationDetailsForCustomer(2);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

}
