package com.hexaware.roadready.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.entities.Payments;
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
	void testViewPaymentHistory() {
		List list=service.viewPaymentHistory(0);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testGetPaymentDetailsForCustomer() {
		List list=service.getPaymentDetailsForCustomer(0);
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testMakePayment() {

	}

}
