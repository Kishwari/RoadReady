package com.hexaware.roadready.restcontroller;

import java.time.LocalDate;
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
import com.hexaware.roadready.exceptions.AgentNotFoundException;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.exceptions.PaymentNotFoundException;
import com.hexaware.roadready.exceptions.ReservationNotFoundException;
import com.hexaware.roadready.service.IAdminService;

@RestController
@RequestMapping("/roadready/admin")
public class AdminRestController {
	
	@Autowired
	IAdminService service;
	
	//manage customers
	
	@PostMapping("/addCustomer")
    public Customers	addCustomer(@RequestBody CustomerDTO customer) {
		return service.addCustomer(customer);
	}
	
<<<<<<< HEAD
	@PutMapping("/updateCustomer")									// using any id ?
	   public CustomerDTO	updateCustomer(@RequestBody CustomerDTO customer) throws CustomerNotFoundException {
		   CustomerDTO checkCustomer = service.updateCustomer(customer);
		   if(checkCustomer==null) {
			   throw new CustomerNotFoundException();
		   }
		   return checkCustomer;
	   }
	
=======
>>>>>>> joshitha
	@GetMapping("/getCustomerById/{customerId}")
	public CustomerDTO	getCustomerById(@PathVariable int customerId) throws CustomerNotFoundException {
		CustomerDTO customer = service.getCustomerById(customerId);
		if(customer==null) {
			throw new CustomerNotFoundException();
		}
		return customer;
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customers>	getAllCustomer(){
		return service.getAllCustomer();
	}
	@DeleteMapping("/deleteCustomerById/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		return service.deleteCustomer(customerId);
	}
	
	@PutMapping("/updateCustomerDetails")
	public Customers	updateCustomer(@RequestBody CustomerDTO customer) throws CustomerNotFoundException {
		Customers checkCustomer = service.updateCustomer(customer);
		if(checkCustomer == null) {
			throw new CustomerNotFoundException();
		}
		return checkCustomer;
	}
	
	
	
	//manage cars 
	
	@PostMapping("/addCar")
    public Cars	addCar(@RequestBody CarDTO car) {
		return service.addCar(car);
	}
    
	@GetMapping("/getCarById/{carId}")
	public CarDTO	getCarById(@PathVariable int carId) throws CarNotFoundException {
		CarDTO car= service.getCarById(carId);
		if(car==null) {
			throw new CarNotFoundException();
		}
		return car;
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
	public Cars	updateCar(@RequestBody CarDTO car) throws CarNotFoundException {
		Cars checkCar = service.updateCar(car);
		if(checkCar == null) {
			throw new CarNotFoundException();
		}
		return checkCar;
	}
    
	@GetMapping("/getPaymentsOfCustomer/{customerId}")
    public List<Payments> getPaymentDetailsForCustomer(@PathVariable int customerId) throws PaymentNotFoundException{
		List<Payments>  payments = service.getPaymentDetailsForCustomer(customerId);
		if(payments == null) {
			throw new PaymentNotFoundException();
			
		}
		return payments;
	}
    
	@GetMapping("/getReservationsOfCustomer/{customerId}")
    public List<Reservations> getReservationDetailsForCustomer(@PathVariable int customerId) throws ReservationNotFoundException{
		List<Reservations> reservations = service.getReservationDetailsForCustomer(customerId);
		if(reservations==null) {
			throw new ReservationNotFoundException();
	    }
		return reservations;
	}
    
    @PutMapping("/discountOnCar/{carId}/{discountPrice}")
    public Cars discountOnCarPrice(@PathVariable int carId ,@PathVariable double discountPrice) throws CarNotFoundException {
    	Cars car = service.discountOnCarPrice(carId, discountPrice);
    	if(car ==null) {
    		throw new CarNotFoundException();
    	}
    	return car;
    }
    
    @PutMapping("/updateCarPrice/{carId}/{newprice}")
    public Cars updateCarPrice(@PathVariable int carId , @PathVariable double newPrice) throws CarNotFoundException {
    	Cars car = service.updateCarPrice(carId, newPrice);
    	if(car == null) {
    		throw new CarNotFoundException();
    	}
    	return car;
    }
    
    
   //manage agents
    @PostMapping("/addAgent")
    public Agent addAgent(@RequestBody AgentDTO agent) {
    	return service.addAgent(agent);
    }
	
    @GetMapping("/getAgentById/{agentId}")
    public AgentDTO getAgentById(@PathVariable int agentId) throws AgentNotFoundException {
    	AgentDTO agent = service.getAgentById(agentId);
    	if(agent==null) {
    		throw new AgentNotFoundException();
    	}
    	return agent;
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
    
    //reports
    
    @GetMapping("/revenueReportBetweenDates/{startDate}/{endDate}")
    public String revenueReportBetweenDates(@PathVariable LocalDate startDate , @PathVariable LocalDate endDate ) {
    	return service.revenueReportBetweenDates(startDate , endDate);
    }
    
    @GetMapping("/revenueGeneratedByCustomer/{customerId}")
    public String revenueReportGeneratedByCustomer(@PathVariable int customerId) {
    	return service.revenueReportGeneratedByCustomer(customerId);
    }
    
    @GetMapping("/totalRevenueReport")
    public String totalRevenueReport() {
    	return service.totalRevenueReport();
    }
    
    
}
