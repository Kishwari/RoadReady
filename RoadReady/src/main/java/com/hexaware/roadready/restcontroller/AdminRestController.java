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
import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Feedback;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.AgentNotFoundException;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.exceptions.PaymentNotFoundException;
import com.hexaware.roadready.exceptions.ReservationNotFoundException;
import com.hexaware.roadready.service.IAdminService;
import com.hexaware.roadready.service.IAgentService;
import com.hexaware.roadready.service.ICarService;
import com.hexaware.roadready.service.ICustomerService;
import com.hexaware.roadready.service.IFeedBackService;
import com.hexaware.roadready.service.IPaymentService;
import com.hexaware.roadready.service.IReservationService;

@RestController
@RequestMapping("/roadready/admin")
public class AdminRestController {
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	ICarService carService;
	
	@Autowired
	IPaymentService paymentService;
	
	@Autowired
	IReservationService reservationService;
	
	@Autowired
	IFeedBackService feedbackService;
	
	@Autowired
	IAgentService agentService;
	
	@Autowired
	IAdminService adminService;
	
	
	//manage customers
	
	@PostMapping("/addCustomer")
    public Customers	addCustomer(@RequestBody CustomerDTO customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/getCustomerById/{customerId}")
	public CustomerDTO	getCustomerById(@PathVariable int customerId) throws CustomerNotFoundException {
		CustomerDTO customer = customerService.getCustomerById(customerId);
		if(customer==null) {
			throw new CustomerNotFoundException();
		}
		return customer;
	}
	
	@GetMapping("/getAllCustomers")
	public List<CustomerDTO>	getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@DeleteMapping("/deleteCustomerById/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		return customerService.deleteCustomer(customerId);
	}
	
	@PutMapping("/updateCustomerDetails")
	public Customers	updateCustomer(@RequestBody CustomerDTO customer) throws CustomerNotFoundException {
		Customers checkCustomer = customerService.updateCustomer(customer);
		if(checkCustomer == null) {
			throw new CustomerNotFoundException();
		}
		return checkCustomer;
	}
	
	
	
	//manage cars 
	
	@PostMapping("/addCar")
    public Cars	addCar(@RequestBody CarDTO car) {
		return carService.addCar(car);
	}
    
	@GetMapping("/getCarById/{carId}")
	public CarDTO	getCarById(@PathVariable int carId) throws CarNotFoundException {
		CarDTO car= carService.getCarById(carId);
		if(car==null) {
			throw new CarNotFoundException("car with id " + carId + "not present");
		}
		return car;
	}
	
	@GetMapping("/getAllCars")
	public List<CarDTO>	getAllCars(){
		return carService.getAllCars();
	}
	
	@DeleteMapping("/deleteCarById/{carId}")
	public String deleteCar(@PathVariable int carId) {
		return carService.deleteCar(carId);
	}
	
	@PutMapping("/updateCarDetails")
	public Cars	updateCar(@RequestBody CarDTO car) throws CarNotFoundException {
		Cars checkCar = carService.updateCar(car);
		if(checkCar == null) {
			throw new CarNotFoundException("car not present");
		}
		return checkCar;
	}
    
	@GetMapping("/getPaymentsOfCustomer/{customerId}")
    public List<Payments> getPaymentDetailsForCustomer(@PathVariable int customerId) throws PaymentNotFoundException{
		List<Payments>  payments = paymentService.getPaymentDetailsForCustomer(customerId);
		if(payments == null) {
			throw new PaymentNotFoundException();
			
		}
		return payments;
	}
    
	@GetMapping("/getReservationsOfCustomer/{customerId}")
    public List<Reservations> getReservationDetailsForCustomer(@PathVariable int customerId) throws ReservationNotFoundException{
		List<Reservations> reservations = reservationService.getReservationDetailsForCustomer(customerId);
		if(reservations==null) {
			throw new ReservationNotFoundException();
	    }
		return reservations;
	}
    
    @PutMapping("/discountOnCarByMake/{make}/{discountPrice}")
    public List<Cars> discountOnCarPrice(@PathVariable String make ,@PathVariable double discountPrice) throws CarNotFoundException {
    	List<Cars>  cars = carService.discountOnCarPriceByMake(make, discountPrice);
    	if(cars.isEmpty()) {
    		throw new CarNotFoundException("car with make " + make+ "not present");
    	}
    	return cars;
    }
    
    @PutMapping("/updateCarPrice/{carId}/{newPrice}")
    public Cars updateCarPrice(@PathVariable int carId , @PathVariable double newPrice) throws CarNotFoundException {
    	Cars car = carService.updateCarPrice(carId, newPrice);
    	if(car == null) {
    		throw new CarNotFoundException("car with id " + carId + "not present");
    	}
    	return car;
    }
    
    
   //manage agents
    @PostMapping("/addAgent")
    public Agent addAgent(@RequestBody AgentDTO agentdto) {
    	return agentService.addAgent(agentdto);
    }
	
    @GetMapping("/getAgentById/{agentId}")
    public AgentDTO getAgentById(@PathVariable int agentId) throws AgentNotFoundException {
    	AgentDTO agent = agentService.getAgentById(agentId);
    	if(agent==null) {
    		throw new AgentNotFoundException();
    	}
    	return agent;
    }
    
    @GetMapping("/getAllAgents")
    public List<Agent> getAllAgents(){
    	return agentService.getAllAgents();
    }
    @DeleteMapping("/deleteAgentById/{agentId}")
    public String deleteAgent(@PathVariable int agentId) {
    	return agentService.deleteAgent(agentId);
    }
    
    @PutMapping("/updateAgentById/{agentId}")
    public Agent updateAgent(@PathVariable int agentId , @RequestBody AgentDTO agent) {
    	return agentService.updateAgent(agentId, agent);
    }
    
    //general
    
   // public String  generateReports(Date startDate, Date endDate, ReportType reportType);
    
    @PostMapping("/adminFeedBack/{feedbackId}/{adminFeedback}")
    public String  giveFeedback(@PathVariable int feedbackId , @PathVariable String adminFeedback) {
    	return feedbackService.adminFeedback(feedbackId ,adminFeedback);
    }
    
    @GetMapping("/viewAllCustomerFeedBacks")
    public List<Feedback> viewAllFeedbacks(){
    	return feedbackService.viewAllFeedbacks();
    }
    
    @GetMapping("/getAllReservations")
    public List <ReservationDTO> viewAllReservations(){
    	return reservationService.viewAllReservations();
    }
    
    @GetMapping("/getAllPayments")
    public List<PaymentDTO> viewAllPayments(){
    	return paymentService.viewAllPayments();
    }
    
    //reports
    
    @GetMapping("/revenueReportBetweenDates/{startDate}/{endDate}")
    public String revenueReportBetweenDates(@PathVariable LocalDate startDate , @PathVariable LocalDate endDate ) {
    	return adminService.revenueReportBetweenDates(startDate , endDate);
    }
    
    @GetMapping("/revenueGeneratedByCustomer/{customerId}")
    public String revenueReportGeneratedByCustomer(@PathVariable int customerId) {
    	return adminService.revenueReportGeneratedByCustomer(customerId);
    }
    
    @GetMapping("/totalRevenueReport")
    public String totalRevenueReport() {
    	return adminService.totalRevenueReport();
    }
    
    
    
    
}
