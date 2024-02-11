package com.hexaware.roadready.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.exceptions.ReservationNotFoundException;
import com.hexaware.roadready.service.IReservationService;

@RestController
@RequestMapping("/roadready/reservations")
public class ReservationRestController {

	@Autowired
	IReservationService reservationService;
	
	 @PutMapping("/modifyReservation/{reservationId}/{dateOfPickup}/{dateOfDropoff}")
	   ReservationDTO modifyReservation(@PathVariable int reservationId ,@PathVariable LocalDate dateOfPickup , @PathVariable LocalDate dateOfDropoff) throws ReservationNotFoundException {
		   ReservationDTO reservation = reservationService.modifyReservation(reservationId , dateOfPickup , dateOfDropoff);
		   if(reservation==null) {
			   throw new ReservationNotFoundException("reservation with id " + reservationId + " doesnt exist");
		   }
		   return reservation;
	   }
	 
	 @DeleteMapping("/cancelReservation/{reservationId}")
	   public String cancelReservation(@PathVariable int reservationId) {
		   return reservationService.cancelReservation(reservationId);
	   }
	   
	 @GetMapping("/getReservationsOfCustomer/{customerId}")
	    public List<ReservationDTO> getReservationDetailsForCustomer(@PathVariable int customerId) throws ReservationNotFoundException{
			List<ReservationDTO> reservations = reservationService.getReservationDetailsForCustomer(customerId);
			if(reservations==null) {
				throw new ReservationNotFoundException("reservation for customer " + customerId + " doesnt exist");
		    }
			
			return reservations;
		}
	 
	 @GetMapping("/viewReservations/{customerId}")
	   public List<ReservationDTO> viewReservations(@PathVariable int customerId) throws ReservationNotFoundException{
		   List<ReservationDTO> reservations =reservationService.viewReservations(customerId);
		   if(reservations==null) {
			   throw new ReservationNotFoundException("reservation for customer " + customerId + " doesnt exist");
		   }
		   return reservations;
	   }
	 
	    @GetMapping("/getAllReservations")
	    public List <ReservationDTO> viewAllReservations(){
	    	return reservationService.viewAllReservations();
	    }
}
