package com.hexaware.roadready.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.service.IAdminService;

@SpringBootTest
class AdminServiceImplTest {

	@Autowired
	IAdminService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testRevenueReportBetweenDates() {
		LocalDate startDate=LocalDate.of(2024, 01, 01);
		LocalDate endDate=LocalDate.of(2024, 04, 04);
		double amount=5290;
		
		String result = service.revenueReportBetweenDates( startDate,endDate);
		
        assertEquals("Total revenue Generated Between " + startDate + " and " +endDate+ " is " + amount, result);
	}

	@Test
	void testRevenueReportGeneratedByCustomer() {
		int customerId=2;
		String result = service.revenueReportGeneratedByCustomer(customerId);
		double amount=1450;
        assertEquals("Total Revenue Generated By Customer " + customerId + " is " +amount,	result);
	}

	@Test
	void testTotalRevenueReport() {
		String result = service.totalRevenueReport();
		double amount=5290;
		assertEquals("Total Revenue generated till today for RoadReady is " + amount,result);
	}

}
