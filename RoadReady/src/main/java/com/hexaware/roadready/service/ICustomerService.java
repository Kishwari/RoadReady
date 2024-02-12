package com.hexaware.roadready.service;

import java.util.List;

import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Customers;

import com.hexaware.roadready.exceptions.CustomerNotFoundException;



public interface ICustomerService {
	
	
    public Customers	addCustomer(CustomerDTO customer);
	
	public CustomerDTO	getCustomerById(int customerId) throws CustomerNotFoundException;
	
	public List<CustomerDTO>	getAllCustomer();
	
	public String deleteCustomer(int customerId);
	
	public Customers updateCustomer(CustomerDTO customerdto) throws  CustomerNotFoundException ;
	
	
	
 
    
}
