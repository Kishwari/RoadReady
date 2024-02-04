package com.hexaware.roadready.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.service.IAdminService;

@RestController
@RequestMapping("/roadready/admin")
public class AdminRestController {
	
	@Autowired
	IAdminService service;
	
	//manage customers
	
	@PostMapping("/addCustomer")
    public CustomerDTO	addCustomer(@RequestBody CustomerDTO customer) {
		return service.addCustomer(customer);
	}
	@GetMapping("/getCustomerById/{customerId}")
	public CustomerDTO	getCustomerById(@PathVariable int customerId) {
		return service.getCustomerById(customerId);
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customers>	getAllCustomer(){
		return service.getAllCustomer();
	}
	@DeleteMapping("/deleteCustomerById/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		return service.deleteCustomer(customerId);
	}
	
	
	
	//manage cars 
	
	@PostMapping("/addCar")
    public CarDTO	addCar(@RequestBody CarDTO car) {
		return service.addCar(car);
	}
    
	@GetMapping("/getCarById/{carId}")
	public CarDTO	getCarById(@PathVariable int carId) {
		return service.getCarById(carId);
	}
	
	@GetMapping("/getAllCars")
	public List<Cars>	getAllCars(){
		return service.getAllCars();
	}
	
	@DeleteMapping("/deleteCarById/{carId}")
	public String deleteCar(@PathVariable int carId) {
		return service.deleteCar(carId);
	}
	
	@PutMapping("/updateCarDetails")
	public CustomerDTO	updateCar(@RequestBody CarDTO car) {
		return service.updateCar(car);
	}
    
	@GetMapping("/getPaymentsOfCustomer/{customerId}")
    public List<Payments> getPaymentDetailsForCustomer(@PathVariable int customerId){
		return service.getPaymentDetailsForCustomer(customerId);
	}
    
	@GetMapping("/getReservationsOfCustomer/{customerId}")
    public List<Reservations> getReservationDetailsForCustomer(@PathVariable int customerId){
		return service.getReservationDetailsForCustomer(customerId);
	}
    
    @PutMapping("/discountOnCar/{carId}/{discountPrice}")
    public CarDTO discountOnCarPrice(@PathVariable int carId ,@PathVariable double discountPrice) {
    	return service.discountOnCarPrice(carId, discountPrice);
    }
    
    @PutMapping("/updateCarPrice/{carId}/{newprice}")
    public CarDTO updateCarPrice(@PathVariable int carId , @PathVariable double newPrice) {
    	return service.updateCarPrice(carId, newPrice);
    }
    
    
   //manage agents
    @PostMapping("/addAgent")
    public AgentDTO addAgent(@RequestBody AgentDTO agent) {
    	return service.addAgent(agent);
    }
	
    @GetMapping("/getAgentById/{agentId}")
    public AgentDTO getAgentById(@PathVariable int agentId) {
    	return service.getAgentById(agentId);
    }
    
    @GetMapping("/getAllAgents")
    public List<Agent> getAllAgents(){
    	return service.getAllAgents();
    }
    @DeleteMapping("/deleteAgentById")
    public String deleteAgent(@PathVariable int agentId) {
    	return service.deleteAgent(agentId);
    }
    
    //general
    
   // public String  generateReports(Date startDate, Date endDate, ReportType reportType);
    
    @PostMapping("/giveFeedBack/{adminFeedback}")
    public String  giveFeedback(@PathVariable String adminFeedback) {
    	return service.giveFeedback(adminFeedback);
    }
    
    @GetMapping("/getAllReservations")
    public List <Reservations> viewAllReservations(){
    	return service.viewAllReservations();
    }
    
    @GetMapping("/getAllPayments")
    public List<Payments> viewAllPayments(){
    	return service.viewAllPayments();
    }
    
}
