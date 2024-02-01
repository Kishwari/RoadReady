package com.hexaware.roadready.service;

import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;

public interface IAgentService {
	
	void checkInAndCheckOut(Customers customer, Cars car);
    
    void provideMaintenanceAlert(Cars car, String alertMessage);
}
