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

import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
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

		CustomerDTO customerdto=new CustomerDTO(9,"Tina","Muneem","tina_mun","tina.muneem@rxmaple.com","muneem@123","3746583980");
		Customers c1=service.addCustomer(customerdto);
		assertNotNull(c1);
		assertEquals(9,c1.getCustomerId());
		assertTrue(c1.getCustomerId() >0);
		}

	@Test
	void testGetCustomerById() throws CustomerNotFoundException {
		CustomerDTO customerdto=service.getCustomerById(4);
		assertEquals("emmadavis",customerdto.getUsername());
		assertNotEquals("emma_davis",customerdto.getUsername());
	}

	@Test
	void testGetAllCustomer() {
		List list=service.getAllCustomer();
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testDeleteCustomer() {
		int customerId=9;
		String result = service.deleteCustomer(customerId);
        assertEquals("customer " + customerId + " deleted successfully", result);
	}

	@Test
	void testUpdateCustomer() throws CustomerNotFoundException {								
		CustomerDTO originalData = new CustomerDTO(8,"Olivia","Taylor","olivyataylor","olivia@example.com","oliviataylorpassword","9998887776");
        CustomerDTO updatedData = new CustomerDTO(8,"Olivia","Taylor","olivyataylor","olivia@example.com","oliviataylorpassword","7688887776");
        Customers result = service.updateCustomer(originalData);
        assertNotEquals(updatedData, result);
	}

}
