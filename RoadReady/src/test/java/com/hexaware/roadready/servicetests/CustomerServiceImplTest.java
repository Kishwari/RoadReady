package com.hexaware.roadready.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.service.ICustomerService;

@SpringBootTest
class CustomerServiceImplTest {

	@Autowired
	ICustomerService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	@Test
	@DisplayName("Insert_Customer")
	void testAddCustomer() {

		CustomerDTO customerdto=new CustomerDTO();
		Customers c1=service.addCustomer(customerdto);
		assertNotNull(c1);
		assertEquals(122,c1.getCustomerId());
		assertTrue(c1.getCustomerId() >0);
		}

	@Test
	void testGetCustomerById() {
		CustomerDTO customerdto=service.getCustomerById(101);
		assertEquals("Tommy",customerdto.getUsername());
		assertNotEquals("smith",customerdto.getUsername());
	}

	@Test
	void testGetAllCustomer() {
		List list=service.getAllCustomer();
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testDeleteCustomer() {

	}

	@Test
	void testUpdateCustomer() {

	}

}
