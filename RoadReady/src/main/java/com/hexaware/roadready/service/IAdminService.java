package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.util.List;


import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.CarNotFoundException;



public interface IAdminService {
	
	
	//manage customer
    public Customers	addCustomer(CustomerDTO customer);
	
	public CustomerDTO	getCustomerById(int customerId);
	
	public List<Customers>	getAllCustomer();
	
	public String deleteCustomer(int customerId);
	
	public Customers	updateCustomer(CustomerDTO customer);
	
	//manage cars 
    public Cars	addCar(CarDTO car);
	
	public CarDTO	getCarById(int carId);
	
	public List<Cars>	getAllCars();
	
	public String deleteCar(int carId);
	
	public Cars	updateCar(CarDTO car);
    
    public List<Payments> getPaymentDetailsForCustomer(int customerId);
    
    public List<Reservations> getReservationDetailsForCustomer(int customerId);
    
    
    public Cars discountOnCarPrice(int carId , double discountPrice) throws CarNotFoundException;
    
    public Cars updateCarPrice(int carId , double newPrice) throws CarNotFoundException;
    
    
   //manage agents
    
    public Agent addAgent(AgentDTO agent);
	
    public AgentDTO getAgentById(int agentId);
    	
    public List<Agent> getAllAgents();
    	
    public String deleteAgent(int agentId);
    
    //general
    
  
    
    public String  giveFeedback(String adminFeedback);
    
    public List <Reservations> viewAllReservations();
 
    public List<Payments> viewAllPayments();
    
    //generate Reports
    
    public String revenueReportBetweenDates(LocalDate startDate, LocalDate endDate);
    
    public String revenueReportGeneratedByCustomer(int customerId);
    
    public String totalRevenueReport();
    

}
