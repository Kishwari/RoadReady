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
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Reservations;
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
         String obtainedValue = service.completeCheckIn(3000);
         String actualValue = "Check-in completed successfully";
         assertEquals(obtainedValue,actualValue);
         
	}

	@Test
	void testCompleteCheckOut() {
		String updatedCarStatus ="available";
		String obtainedValue = service.completeCheckOut(3000,updatedCarStatus);
        String actualValue = "checkout completed successfully and car status updated to " + updatedCarStatus;
        assertEquals(obtainedValue,actualValue);
	}

	@Test
	void testUpdateCarAvailability() throws CarNotFoundException {
		int carId=1000;
		String carStatus="available";
		
        Cars updatedCar = service.updateCarAvailability(carStatus,carId);
        assertEquals(carStatus,updatedCar.getCarStatus());
	}

	@Test
	void testVerifyIdentity() {
		
			CustomerDTO customerdto=service.verifyIdentity(1);
			assertEquals("johndoe",customerdto.getUsername());
			assertNotEquals("johnDoe",customerdto.getUsername());
		}


	

	@Test
	void testCarMaintenanceReport() {

		String obtainedString= service.carMaintenanceReport();
		String expectedReport = "Cars under maintenance: "
				+ "Car [carId=1001, make=Honda, model=Civic, location=pune, dailyRate=60.0, carStatus=maintenance, specification=Manual transmission, Sunroof, passengerCapacity=4]";
		assertEquals(obtainedString , expectedReport);
	}

	@Test
	void testAddAgent() {
		AgentDTO agentdto=new AgentDTO(202,"agent202","agent202password");
		Agent e1=service.addAgent(agentdto);
		assertNotNull(e1);
		assertEquals(202,e1.getAgentId());
		assertTrue(e1.getAgentId() >0);
	}

	@Test
	void testGetAgentById() throws AgentNotFoundException {
		AgentDTO agent=service.getAgentById(201);
		assertEquals("agent201",agent.getUsername());
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
		int agentId=203;
		String result = service.deleteAgent(agentId);
        assertEquals("agent with id " + agentId + "deleted succesfully", result);
	}

	@Test
	void testUpdateAgent() throws AgentNotFoundException {
		int agentId=201;
		AgentDTO originalData = new AgentDTO(201,"agent201" ,"agentpassword");
		AgentDTO updatedData = new AgentDTO(201, "agent201","agentpassword");
		Agent updatedAgent = new Agent();
		updatedAgent.setAgentId(updatedData.getAgentId());
		updatedAgent.setUsername(updatedData.getUsername());
		updatedAgent.setPassword(updatedData.getPassword());
        Agent result = service.updateAgent(agentId,originalData);
        assertEquals(updatedAgent, result);
	}

}
