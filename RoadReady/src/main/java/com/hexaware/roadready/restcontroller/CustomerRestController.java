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

import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.dto.CustomerFeedbackDTO;
import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Feedback;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.exceptions.InvalidPaymentException;
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
@RequestMapping("/roadready/customers")
public class CustomerRestController {
	
	@Autowired
	ICustomerService customerService;
	


	@PostMapping("/addCustomer")
    public Customers	addCustomer(@RequestBody CustomerDTO customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/getCustomerById/{customerId}")
	public CustomerDTO	getCustomerById(@PathVariable int customerId) throws CustomerNotFoundException {
		CustomerDTO customer = customerService.getCustomerById(customerId);
		if(customer==null) {
			throw new CustomerNotFoundException("custome with id " + customerId + "not found");
			
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
			throw new CustomerNotFoundException("customer not found");
		}
		return checkCustomer;
	}
	@PostMapping("/registerNewCustomer")
	public Customers registration(CustomerDTO customerdto) {
		return customerService.addCustomer(customerdto);
	}
	
  
  
   
  /* @PostMapping("/makeReservation")									//	check  mapping for all methods below this
   Reservations makeReservation(@RequestBody ReservationDTO reservation) throws InvalidDateException {
	   Reservations checkReservation = reservationService.makeReservation(reservation);
	   LocalDate today = LocalDate.now();
	   if(checkReservation.getDateOfPickup().isBefore(today)) {
	       throw new InvalidDateException();
	   }
	   return checkReservation;
   }*/
  
  
   
  
  
   
   
 
   
   
   
   

   
   
}

