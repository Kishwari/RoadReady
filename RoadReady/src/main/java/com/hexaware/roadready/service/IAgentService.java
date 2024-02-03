package com.hexaware.roadready.service;



public interface IAgentService {
	
	
	 public String completeCheckIn(int reservationId);
	 
	 public String completeCheckOut(int reservationId);
	        
     public String updateCarAvailability(int carId);
	 
     public String verifyIdentity(int customerId);
     
     public String agentReport();
     
     public String provideCarMaintenanceAlerts(int carId);    
     
     
}
