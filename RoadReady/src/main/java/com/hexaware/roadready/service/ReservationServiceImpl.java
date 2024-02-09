package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.ReservationNotFoundException;
import com.hexaware.roadready.repository.PaymentRepository;
import com.hexaware.roadready.repository.ReservationRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ReservationServiceImpl implements IReservationService{
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	PaymentRepository paymentRepo;
	
	@Override
	public List<ReservationDTO> viewAllReservations() {
		 List<Reservations> reservationList = reservationRepo.findAll();
		    List<ReservationDTO> reservationDTOList = new ArrayList<>();
		    for (Reservations reservation : reservationList) {
		        ReservationDTO reservationDTO = new ReservationDTO();
		        reservationDTO.setReservationId(reservation.getResevationId());
		        reservationDTO.setReservationStatus(reservation.getReservationstatus());
		        reservationDTO.setDateOfReservation(reservation.getDateOfReservation());
		        reservationDTO.setDateOfPickup(reservation.getDateOfPickup());
		        reservationDTO.setDateOfDropoff(reservation.getDateOfDropoff());

		        reservationDTOList.add(reservationDTO);
		    }
		    return reservationDTOList;
		
	}

	/*@Override
	public Reservations makeReservation(int reservationId,LocalDate dateOfPickup ,LocalDate dateOfDropoff) {
		Reservations reservation = new Reservations();
        reservation.setResevationId(reservationId);
        reservation.setDateOfReservation(LocalDate.now());
        reservation.setDateOfPickup(dateOfPickup);
        reservation.setDateOfDropoff(dateOfDropoff);
        if 
        reservation.setReservationstatus(reservationdto.getReservationStatus());
        
		
		return null;
	}*/

	@Override
	public String cancelReservation(int reservationId) {
		reservationRepo.deleteById(reservationId);
		Reservations deletedReservation = reservationRepo.findById(reservationId).orElse(null);
		if(deletedReservation == null) {
			
			
			return "your reservation " + reservationId +" cancelled successfully";
			
		}
		else {
			return "cancellation of reservation  failed";
		}
	}

	
	
	@Override
	public Reservations modifyReservation(int reservationId, LocalDate dateOfPickup, LocalDate dateOfDropoff) throws ReservationNotFoundException {
	    Reservations reservation = reservationRepo.findById(reservationId)
	            .orElseThrow(() -> new ReservationNotFoundException("Reservation with id " + reservationId + " not found"));

	    Payments payment = reservation.getPayment();
	    if (payment == null) {
	        throw new IllegalStateException("Payment not found for reservation with id " + reservationId);
	    }

	    long totalDaysAfterModification = ChronoUnit.DAYS.between(dateOfPickup, dateOfDropoff);
	    Double dailyRate = reservation.getCar().getDailyRate();
	    Double newAmount = dailyRate * totalDaysAfterModification;
	    Double oldAmount = payment.getAmountPaid();
	    Double modifiedAmount = Math.abs(newAmount - oldAmount);

	    if (newAmount > oldAmount) {
	        payment.setAmountPaid(oldAmount + modifiedAmount);
	    } else {
	        payment.setAmountPaid(oldAmount - modifiedAmount);
	    }

	    paymentRepo.save(payment);

	    reservation.setDateOfPickup(dateOfPickup);
	    reservation.setDateOfDropoff(dateOfDropoff);

	    return reservationRepo.save(reservation);
	}

	
	

	@Override
	public List<Reservations> viewReservations(int customerId) {
		return reservationRepo.viewReservationHistory(customerId);
	}

	@Override
	public List<Reservations> getReservationDetailsForCustomer(int customerId) {
		return reservationRepo.getReservationDetailsForCustomer(customerId);
	}
}
