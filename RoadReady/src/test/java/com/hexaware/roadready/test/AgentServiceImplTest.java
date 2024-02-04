package com.hexaware.roadready.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.service.IAgentService;

@SpringBootTest
class AgentServiceImplTest {

	Logger logger=LoggerFactory.getLogger(AgentServiceImplTest.class);

	
	@Autowired
	IAgentService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testCompleteCheckIn() {
		

	}

	@Test
	void testCompleteCheckOut() {

	}

	@Test
	void testUpdateCarAvailability() {

	}

	@Test
	void testVerifyIdentity() {

	}

	@Test
	void testAgentReport() {

	}

	@Test
	void testProvideCarMaintenanceAlerts() {

	}

}
