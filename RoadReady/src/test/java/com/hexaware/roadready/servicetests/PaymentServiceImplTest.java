package com.hexaware.roadready.servicetests;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.exceptions.PaymentNotFoundException;
import com.hexaware.roadready.service.IPaymentService;

@SpringBootTest
class PaymentServiceImplTest {

	@Autowired
	IPaymentService service;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testViewAllPayments() {

		List list=service.viewAllPayments();
		boolean flag=list.isEmpty();
		assertFalse(flag);	
		}

	@Test
	void testViewPaymentHistory() throws PaymentNotFoundException {
		List list=service.viewPaymentHistory(123);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testGetPaymentDetailsForCustomer() throws PaymentNotFoundException {
		List list=service.getPaymentDetailsForCustomer(1);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testMakePayment() {
            
		PaymentDTO payment = service.makePayment(int customerId ,int carId , int reservationId ,PaymentDTO paymentdto ,LocalDate dateOfPickup , LocalDate dateOfdropoff)
	
		}

}
