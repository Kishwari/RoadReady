package com.hexaware.roadready.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.CustomerDTO;

import com.hexaware.roadready.entities.Customers;

import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.service.ICustomerService;

@RestController
@RequestMapping("/roadready/customers")
public class CustomerRestController {
	
	Logger logger=LoggerFactory.getLogger(CustomerRestController.class);

	@Autowired
	ICustomerService customerService;
	


	@PostMapping("/addCustomer")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Customers	addCustomer(@RequestBody CustomerDTO customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/getCustomerById/{customerId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public CustomerDTO	getCustomerById(@PathVariable int customerId){
		CustomerDTO customer=new CustomerDTO();
		try {
			customer = customerService.getCustomerById(customerId);
		} catch (CustomerNotFoundException e) {

			e.printStackTrace();
		}
    	logger.warn("Might throw exception CustomerNotFoundException ");
		return customer;
	}
	
	@GetMapping("/getAllCustomers")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<CustomerDTO>	getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@DeleteMapping("/deleteCustomerById/{customerId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String deleteCustomer(@PathVariable int customerId) {
		return customerService.deleteCustomer(customerId);
	}
	
	@PutMapping("/updateCustomerDetails")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Customers	updateCustomer(@RequestBody CustomerDTO customer) {
		Customers checkCustomer=new Customers();
		try {
			checkCustomer = customerService.updateCustomer(customer);
		} catch (CustomerNotFoundException e) {

			e.printStackTrace();
		}
		return checkCustomer;
	}
	@PostMapping("/registerNewCustomer")
	@PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
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

