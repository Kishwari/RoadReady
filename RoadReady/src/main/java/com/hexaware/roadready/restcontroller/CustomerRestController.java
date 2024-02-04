package com.hexaware.roadready.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Feedback;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
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
   public List<Cars> searchCars(@PathVariable String location , @PathVariable String make,@PathVariable String model){
	   return service.searchCars(location , make , model);
  
   }
   @PostMapping("/makeReservation")									//	check  mapping for all methods below this
   ReservationDTO makeReservation(ReservationDTO reservation) {
	   return service.makeReservation(reservation);
   }
   
   @DeleteMapping("/cancelReservation/{reservationId}")
   String cancelReservation(@PathVariable int reservationId) {
	   return service.cancelReservation(reservationId);
   }
   
   @PutMapping("/modifyReservation/{reservationId}")
   ReservationDTO modifyReservation(@PathVariable int reservationId) {
	   return service.modifyReservation(reservationId);
   }
   
 
   
   void provideFeedback(Feedback feedback) { 		// return type I think feedback ?
	  //  return service.provideFeedback(feedback);
   }
   
   @GetMapping("/viewPaymentHistory/{customerId}")
   List<Payments> viewPaymentHistory(@PathVariable int customerId){
	   return service.viewPaymentHistory(customerId);
   }
   
   @GetMapping("/viewReservations/{customerId}")
   List<Reservations> viewReservations(@PathVariable int customerId){
	   return service.viewReservations(customerId);
   }

   @PutMapping("/updateCustomer")									// using any id ?
   public CustomerDTO	updateCustomer(CustomerDTO customer) {
	   return service.updateCustomer(customer);
   }
   
}

