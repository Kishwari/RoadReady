package com.hexaware.roadready.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.exceptions.AgentNotFoundException;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.CustomerIdentityNotFoundException;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;

public interface IAgentService {
	
	
	   
     
     
	public Agent addAgent(AgentDTO agent);
 	
    public AgentDTO getAgentById(int agentId) throws AgentNotFoundException;
    	
    public List<Agent> getAllAgents();
    	
    public String deleteAgent(int agentId);
    
    public Agent updateAgent(AgentDTO agent);
    
     
     
     
     public String completeCheckIn(int reservationId);
	 
	 public String completeCheckOut(int reservationId , String carStatus);
	        
     public CarDTO updateCarAvailability(String carStatus ,int carId) throws CarNotFoundException;
	 
     public ResponseEntity<byte[]> verifyIdentity(Long customerId) throws CustomerIdentityNotFoundException;
     
     public String carMaintenanceReport();
     
     
     boolean checkIfAgentExists(String username);
     String updateAgentPassword(String username, String newPassword);
}
