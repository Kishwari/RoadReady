package com.hexaware.roadready.service;

import java.time.LocalDate;

import com.hexaware.roadready.dto.AdminDTO;
import com.hexaware.roadready.entities.Admin;



public interface IAdminService {
	
	
	//manage customer
   /* public Customers	addCustomer(CustomerDTO customer);
	
	public CustomerDTO	getCustomerById(int customerId);
	
	public List<CustomerDTO>	getAllCustomer();
	
	public String deleteCustomer(int customerId);

	public Customers	updateCustomer(CustomerDTO customer);

	
	//manage cars 
    public Cars	addCar(CarDTO car);
	
	public CarDTO	getCarById(int carId);
	
	public List<CarDTO>	getAllCars();
	
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
    
    public List <ReservationDTO> viewAllReservations();
 
    public List<PaymentDTO> viewAllPayments();  */
    
	//admin
	
	public Admin addAdmin(AdminDTO admindto);
	
    //generate Reports
    
    public String revenueReportBetweenDates(LocalDate startDate, LocalDate endDate);
    
    public String revenueReportGeneratedByCustomer(int customerId);
    
    public String totalRevenueReport();
    
    
    //agent 
   /* public Agent addAgent(AgentDTO agentdto);
 	
    public AgentDTO getAgentById(int agentId);
    	
    public List<Agent> getAllAgents();
    	
    public String deleteAgent(int agentId);*/
    

}
