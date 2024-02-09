package com.hexaware.roadready.servicetests;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

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

	}

	@Test
	void testRevenueReportGeneratedByCustomer() {

		
	}

	@Test
	void testTotalRevenueReport() {

	}

}
