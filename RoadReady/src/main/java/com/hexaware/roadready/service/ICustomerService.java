package com.hexaware.roadready.service;

import java.util.Date;
import java.util.List;

import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Feedback;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;



public interface ICustomerService {
	
	
    public Customers	addCustomer(CustomerDTO customer);
	
	public CustomerDTO	getCustomerById(int customerId);
	
	public List<CustomerDTO>	getAllCustomer();
	
	public String deleteCustomer(int customerId);
	
	public Customers updateCustomer(CustomerDTO customerdto);
	
	
	
 
    
}
