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
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.exceptions.AgentNotFoundException;
import com.hexaware.roadready.exceptions.CarNotFoundException;
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
	void testUpdateCarAvailability() throws CarNotFoundException {
		int carId=203;
		String carStatus="available";
		
        Cars updatedCar = service.updateCarAvailability(carStatus,carId);
        assertEquals(carStatus,updatedCar.getCarStatus());
	}

	@Test
	void testVerifyIdentity() {
	

	}

	@Test
	void testCarMaintenanceReport() {

	}

	@Test
	void testAddAgent() {
		AgentDTO agentdto=new AgentDTO(303,"bittu","BITTU");
		Agent e1=service.addAgent(agentdto);
		assertNotNull(e1);
		assertEquals(303,e1.getAgentId());
		assertTrue(e1.getAgentId() >0);
	}

	@Test
	void testGetAgentById() throws AgentNotFoundException {
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
		int agentId=202;
		String result = service.deleteAgent(agentId);
        assertEquals("agent with id " + agentId + "deleted succesfully", result);
	}

	@Test
	void testUpdateAgent() {
		int agentId=101;
		AgentDTO originalData = new AgentDTO(101, "laxman01","LAXMAN");
		AgentDTO updatedData = new AgentDTO(101, "laxman101","laxMAN");
        Agent result = service.updateAgent(agentId,originalData);
        assertEquals(updatedData, result);
	}

}
