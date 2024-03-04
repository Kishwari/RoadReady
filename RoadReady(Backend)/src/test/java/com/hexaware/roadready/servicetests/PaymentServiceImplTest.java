package com.hexaware.roadready.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.dto.PaymentAndReservationDTO;
import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.InvalidPaymentException;
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
		List list=service.viewPaymentHistory(455);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testGetPaymentDetailsForCustomer() throws PaymentNotFoundException {
		List list=service.getPaymentDetailsForCustomer(455);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testMakePayment() throws InvalidPaymentException, CarNotFoundException {
        PaymentAndReservationDTO paymentdto = new PaymentAndReservationDTO(2000,"upi",455,1160 ,LocalDate.of(2024, 3, 10) , LocalDate.of(2024, 3, 30));
        PaymentAndReservationDTO payment = service.makePaymentAndReservation(paymentdto);
       // PaymentAndReservationDTO expectedPayment = new PaymentDTO(2001,2320,LocalDate.of(2024 , 2, 12),"debitcard");
        assertNotNull(payment);
        assertEquals(payment.getAmountPaid() , paymentdto.getAmountPaid());
      
	}

}
