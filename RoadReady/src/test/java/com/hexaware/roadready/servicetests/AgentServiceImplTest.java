package com.hexaware.roadready.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.service.IAgentService;

@SpringBootTest
class AgentServiceImplTest {

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
	void testCarMaintenanceReport() {

	}

	@Test
	void testAddAgent() {
		AgentDTO agentdto=new AgentDTO(122,"username","password");
		Agent e1=service.addAgent(agentdto);
		assertNotNull(e1);
		assertEquals(122,e1.getAgentId());
		assertTrue(e1.getAgentId() >0);
	}

	@Test
	void testGetAgentById() {
		AgentDTO agent=service.getAgentById(101);
		assertEquals("Tommy",agent.getUsername());
		assertNotEquals("smith",agent.getUsername());
	}

	@Test
	void testGetAllAgents() {
		List list=service.getAllAgents();
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

	@Test
	void testDeleteAgent() {

	}

	@Test
	void testUpdateAgent() {

	}

}
