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
import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Feedback;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.exceptions.InvalidDateException;
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
	
   
   @GetMapping("/getAvailableCars")
	public List<Cars> getAvailableCars(){
		return carService.getAvailableCars();
	}
   
   @GetMapping("/searchCars/{location}/{make}/{model}")
   public List<Cars> searchCars(@PathVariable String location , @PathVariable String make,@PathVariable String model) throws CarNotFoundException{
	   List<Cars> cars= carService.searchCars(location , make , model);
	   if(cars==null) {
		   throw new CarNotFoundException();
	   }
       return cars;
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
  
   @PostMapping("/makePayment/{customerId}/{carId}/{dateOfPickup}/{dateOfDropoff}")									//	check  mapping for all methods below this
   public Payments makePayment(@PathVariable int customerId , @PathVariable int carId ,  @PathVariable LocalDate dateOfPickup , @PathVariable LocalDate dateOfDropoff ,@RequestBody PaymentDTO paymentdto  ) {
	   Payments payment = new Payments();
	try {
		payment = paymentService.makePayment(customerId , carId ,paymentdto, dateOfPickup , dateOfDropoff);
	} catch (InvalidPaymentException e) {
		
		e.printStackTrace();
	}
	   
	   return payment;
   }
   
   @DeleteMapping("/cancelReservation/{reservationId}")
   public String cancelReservation(@PathVariable int reservationId) {
	   return reservationService.cancelReservation(reservationId);
   }
   
   /*@PutMapping("/modifyReservation")
   Reservations modifyReservation(@RequestBody ReservationDTO reservation) throws ReservationNotFoundException {
	   Reservations checkReservation = reservationService.modifyReservation(reservation);
	   if(checkReservation==null) {
		   throw new ReservationNotFoundException();
	   }
	   return checkReservation;
   }*/
   
 
   @PostMapping("/CustomerFeedback")
  public Feedback provideFeedback(@RequestBody Feedback feedback) { 		// return type I think feedback ?
	  return feedbackService.provideFeedback(feedback);
   }
   
   @GetMapping("/viewPaymentHistory/{customerId}")
   public List<Payments> viewPaymentHistory(@PathVariable int customerId) throws PaymentNotFoundException{
	   List<Payments> payments= paymentService.viewPaymentHistory(customerId);
	   if(payments==null){
		   throw new PaymentNotFoundException();
   }
	   return payments;
}
   
   @GetMapping("/viewReservations/{customerId}")
   public List<Reservations> viewReservations(@PathVariable int customerId) throws ReservationNotFoundException{
	   List<Reservations> reservations =reservationService.viewReservations(customerId);
	   if(reservations==null) {
		   throw new ReservationNotFoundException();
	   }
	   return reservations;
   }

   
   
}

