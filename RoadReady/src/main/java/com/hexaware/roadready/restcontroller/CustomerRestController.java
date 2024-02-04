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
import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Feedback;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.exceptions.InvalidDateException;
import com.hexaware.roadready.exceptions.PaymentNotFoundException;
import com.hexaware.roadready.exceptions.ReservationNotFoundException;
import com.hexaware.roadready.service.ICustomerService;

@RestController
@RequestMapping("/roadready/customers")
public class CustomerRestController {
	
   @Autowired
   ICustomerService service;
   
   @GetMapping("/getAvailableCars")
	public List<Cars> getAvailableCars(){
		return service.getAvailableCars();
	}
   
   @GetMapping("/searchCars/{location}/{make}/{model}")
   public List<Cars> searchCars(@PathVariable String location , @PathVariable String make,@PathVariable String model) throws CarNotFoundException{
	   List<Cars> cars= service.searchCars(location , make , model);
	   if(cars==null) {
		   throw new CarNotFoundException();
	   }
       return cars;
   }
   @PostMapping("/makeReservation")									//	check  mapping for all methods below this
   ReservationDTO makeReservation(@RequestBody ReservationDTO reservation) throws InvalidDateException {
	   ReservationDTO checkReservation = service.makeReservation(reservation);
	   LocalDate today = LocalDate.now();
	   if(checkReservation.getDateOfPickup().isBefore(today)) {
	       throw new InvalidDateException();
	   }
	   return checkReservation;
   }
  
   
   @DeleteMapping("/cancelReservation/{reservationId}")
   String cancelReservation(@PathVariable int reservationId) {
	   return service.cancelReservation(reservationId);
   }
   
   @PutMapping("/modifyReservation")
   ReservationDTO modifyReservation(@RequestBody ReservationDTO reservation) throws ReservationNotFoundException {
	   ReservationDTO checkReservation = service.modifyReservation(reservation);
	   if(checkReservation==null) {
		   throw new ReservationNotFoundException();
	   }
	   return checkReservation;
   }
   
 
   @PostMapping("/CustomerFeedback")
   Feedback provideFeedback(@RequestBody Feedback feedback) { 		// return type I think feedback ?
	  return service.provideFeedback(feedback);
   }
   
   @GetMapping("/viewPaymentHistory/{customerId}")
   List<Payments> viewPaymentHistory(@PathVariable int customerId) throws PaymentNotFoundException{
	   List<Payments> payments= service.viewPaymentHistory(customerId);
	   if(payments==null){
		   throw new PaymentNotFoundException();
   }
	   return payments;
}
   
   @GetMapping("/viewReservations/{customerId}")
   List<Reservations> viewReservations(@PathVariable int customerId) throws ReservationNotFoundException{
	   List<Reservations> reservations =service.viewReservations(customerId);
	   if(reservations==null) {
		   throw new ReservationNotFoundException();
	   }
	   return reservations;
   }

   @PutMapping("/updateCustomer")									// using any id ?
   public CustomerDTO	updateCustomer(@RequestBody CustomerDTO customer) throws CustomerNotFoundException {
	   CustomerDTO checkCustomer = service.updateCustomer(customer);
	   if(checkCustomer==null) {
		   throw new CustomerNotFoundException();
	   }
	   return checkCustomer;
   }
   
}

