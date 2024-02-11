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
		int reservationId=101;
		String result = service.cancelReservation(reservationId);
        assertEquals("your reservation " + reservationId +" cancelled successfully", result);
	}

	/*@Test
	void testModifyReservation() {
		 int reservationId = 1;
	        LocalDate dateOfPickup = LocalDate.of(2024, 3, 15);
	        LocalDate dateOfDropoff = LocalDate.of(2024, 3, 20);
		 ReservationDTO originalData = new ReservationDTO(1,"reserved",LocalDate.of(2024, 2, 25),LocalDate.of(2024, 3, 3),LocalDate.of(2024, 4, 4));
		 ReservationDTO result = service.modifyReservation(reservationId,dateOfPickup,dateOfDropoff);
	        assertEquals(originalData, result);

	}*/

	@Test
	void testViewReservations() {
		List list=service.viewReservations(111);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testGetReservationDetailsForCustomer() {
		List list=service.getReservationDetailsForCustomer(111);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

}
