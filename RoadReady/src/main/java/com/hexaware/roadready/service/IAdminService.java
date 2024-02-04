package com.hexaware.roadready.service;

import java.util.List;


import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;



public interface IAdminService {
	
	
	//manage customer
    public CustomerDTO	addCustomer(CustomerDTO customer);
	
	public CustomerDTO	getCustomerById(int customerId);
	
	public List<Customers>	getAllCustomer();
	
	public String deleteCustomer(int customerId);
	
	//public CustomerDTO	updateCustomer(CustomerDTO customer);
	
	//manage cars 
    public CarDTO	addCar(CarDTO car);
	
	public CarDTO	getCarById(int carId);
	
	public List<Cars>	getAllCars();
	
	public String deleteCar(int carId);
	
	public CarDTO	updateCar(CarDTO car);
    
    public List<Payments> getPaymentDetailsForCustomer(int customerId);
    
    public List<Reservations> getReservationDetailsForCustomer(int customerId);
    
    
    public CarDTO discountOnCarPrice(int CarId , double discountPrice);
    
    public CarDTO updateCarPrice(int carId , double newPrice);
    
    
   //manage agents
    
    public AgentDTO addAgent(AgentDTO agent);
	
    public AgentDTO getAgentById(int agentId);
    	
    public List<Agent> getAllAgents();
    	
    public String deleteAgent(int agentId);
    
    //general
    
   // public String  generateReports(Date startDate, Date endDate, ReportType reportType);
    
    public String  giveFeedback(String adminFeedback);
    
    public List <Reservations> viewAllReservations();
 
    public List<Payments> viewAllPayments();
    

}
