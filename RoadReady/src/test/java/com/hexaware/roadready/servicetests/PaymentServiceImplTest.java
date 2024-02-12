package com.hexaware.roadready.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		List list=service.viewPaymentHistory(2);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testGetPaymentDetailsForCustomer() throws PaymentNotFoundException {
		List list=service.getPaymentDetailsForCustomer(2);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testMakePayment() throws InvalidPaymentException, CarNotFoundException {
        PaymentDTO paymentdto = new PaymentDTO(2001,2320,LocalDate.of(2024, 2, 12) ,"debitcard");
		PaymentDTO payment = service.makePayment(2 ,1002 ,3001 ,paymentdto ,LocalDate.of(2024, 2, 20) , LocalDate.of(2024, 3, 20));
		PaymentDTO expectedPayment = new PaymentDTO(2001,2320,LocalDate.of(2024 , 2, 12),"debitcard");
	    assertEquals(expectedPayment.getAmountPaid() , payment.getAmountPaid());
	}

}
