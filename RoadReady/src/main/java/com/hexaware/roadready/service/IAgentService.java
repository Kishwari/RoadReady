package com.hexaware.roadready.service;

import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;

public interface IAgentService {
	
	
	 public String completeCheckIn(int reservationId);
	 
	 public String completeCheckOut(int reservationId);
	        
     public CarDTO updateCarAvailability(int carId);
	 
     public CustomerDTO verifyIdentity(int customerId);
     
     public String carMaintenanceReport(String maintenance);    
     
     
}
