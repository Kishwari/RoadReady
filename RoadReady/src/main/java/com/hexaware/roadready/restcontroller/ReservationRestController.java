package com.hexaware.roadready.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.exceptions.ReservationNotFoundException;
import com.hexaware.roadready.service.IReservationService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/roadready/reservations")
public class ReservationRestController {

	Logger logger=LoggerFactory.getLogger(ReservationRestController.class);

	
	@Autowired
	IReservationService reservationService;
	
	 @PutMapping("/modifyReservation/{reservationId}/{dateOfPickup}/{dateOfDropoff}")
	 @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
	   ReservationDTO modifyReservation(@PathVariable int reservationId ,@PathVariable LocalDate dateOfPickup , @PathVariable LocalDate dateOfDropoff) throws ReservationNotFoundException {
		   ReservationDTO reservation = reservationService.modifyReservation(reservationId , dateOfPickup , dateOfDropoff);
		   return reservation;
	   }
	 
	 @DeleteMapping("/cancelReservation/{reservationId}")
	 @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
	   public String cancelReservation(@PathVariable int reservationId) {
	    	logger.info("Cancelling the reservation");
		   return reservationService.cancelReservation(reservationId);
	   }
	   
	 @GetMapping("/getReservationsOfCustomer/{customerId}")
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	    public List<ReservationDTO> getReservationDetailsForCustomer(@PathVariable int customerId) throws ReservationNotFoundException{
			List<ReservationDTO> reservations = reservationService.getReservationDetailsForCustomer(customerId);
			if(reservations==null) {
				throw new ReservationNotFoundException("reservation for customer " + customerId + " doesnt exist");
		    }
			
			return reservations;
		}
	 
	 @GetMapping("/viewReservationHistory/{customerId}")
	 @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
	   public List<ReservationDTO> viewReservations(@PathVariable int customerId) throws ReservationNotFoundException{
		   List<ReservationDTO> reservations =reservationService.viewReservations(customerId);
		   if(reservations==null) {
			   throw new ReservationNotFoundException("reservation for customer " + customerId + " doesnt exist");
		   }
		   return reservations;
	   }
	 
	    @GetMapping("/getAllReservations")
	    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	    public List <ReservationDTO> viewAllReservations(){
	    	logger.info("Listing all the reservations");
	    	return reservationService.viewAllReservations();
	    }
}
