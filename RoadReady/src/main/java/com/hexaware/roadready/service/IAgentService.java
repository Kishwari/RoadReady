package com.hexaware.roadready.service;

import java.util.List;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;

public interface IAgentService {
	
	
	   
     
     
	public Agent addAgent(AgentDTO agent);
 	
    public AgentDTO getAgentById(int agentId);
    	
    public List<Agent> getAllAgents();
    	
    public String deleteAgent(int agentId);
     
     
     
     public String completeCheckIn(int reservationId);
	 
	 public String completeCheckOut(int reservationId);
	        
     public CarDTO updateCarAvailability(int carId);
	 
     public CustomerDTO verifyIdentity(int customerId);
     
     public String carMaintenanceReport(String maintenance);
     
     
}
