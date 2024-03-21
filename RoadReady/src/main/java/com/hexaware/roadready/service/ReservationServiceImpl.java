package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.dto.ReservationListDTO;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.ReservationNotFoundException;
import com.hexaware.roadready.repository.CarRepository;
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
	
	@Autowired
	CarRepository carRepo;
	
	@Override
	public List<ReservationListDTO> viewAllReservations() {
		 List<Reservations> reservationList = reservationRepo.findAll();
		    List<ReservationListDTO> reservationDTOList = new ArrayList<>();
		    for (Reservations reservation : reservationList) {
		    	ReservationListDTO reservationDTO = new ReservationListDTO();
		        reservationDTO.setReservationId(reservation.getResevationId());
		        reservationDTO.setReservationStatus(reservation.getReservationstatus());
		        reservationDTO.setDateOfReservation(reservation.getDateOfReservation());
		        reservationDTO.setDateOfPickup(reservation.getDateOfPickup());
		        reservationDTO.setDateOfDropoff(reservation.getDateOfDropoff());
		        reservationDTO.setCustomerId(reservation.getCustomer().getCustomerId());
		        reservationDTO.setCarId(reservation.getCar().getCarId());
		        reservationDTO.setPaymentId(reservation.getPayment().getPaymentId());

		        reservationDTOList.add(reservationDTO);
		    }
		    return reservationDTOList;
		
	}

	

	@Override
	public String cancelReservation(int reservationId) {
		
		Reservations reservation = reservationRepo.findById(reservationId).orElse(null);
		
		int carId=reservation.getCar().getCarId();
		
		reservationRepo.deleteById(reservationId);
		Reservations deletedReservation = reservationRepo.findById(reservationId).orElse(null);
		if(deletedReservation == null) {
			
			
			carRepo.updateCarAvailability("available",carId);
			
			return "your reservation " + reservationId +" cancelled successfully";
			
		}
		else {
			return "cancellation of reservation  failed";
		}
	}

	
	
	@Override
	public ReservationDTO modifyReservation(int reservationId, LocalDate dateOfPickup, LocalDate dateOfDropoff) throws ReservationNotFoundException {
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
	    reservation.setReservationStatus("reserved");
        reservation.setDateOfReservation(LocalDate.now());
	    Reservations modifiedReservation = reservationRepo.save(reservation);
	    if(modifiedReservation !=null) {
	    ReservationDTO reservationdto = new ReservationDTO();
	    reservationdto.setReservationId(modifiedReservation.getResevationId());
	    reservationdto.setReservationStatus(modifiedReservation.getReservationstatus());
	    reservationdto.setDateOfReservation(modifiedReservation.getDateOfReservation());
	    reservationdto.setDateOfPickup(modifiedReservation.getDateOfPickup());
	    reservationdto.setDateOfDropoff(modifiedReservation.getDateOfDropoff());
	    
	    return reservationdto;}
	    else {
			   throw new ReservationNotFoundException("reservation with id " + reservationId + " doesnt exist");

	    }
	}

	
	

	@Override
	public List<ReservationListDTO> viewReservations(int customerId) {
		List<Reservations> reservationsList = reservationRepo.viewReservationHistory(customerId);
		List<ReservationListDTO> reservationDTOList = new ArrayList<>();
		for(Reservations reservation : reservationsList) {
			ReservationListDTO reservationdto = new ReservationListDTO();
			reservationdto.setReservationId(reservation.getResevationId());
			reservationdto.setReservationStatus(reservation.getReservationstatus());
			reservationdto.setDateOfReservation(reservation.getDateOfReservation());
			reservationdto.setDateOfPickup(reservation.getDateOfPickup());
			reservationdto.setDateOfDropoff(reservation.getDateOfDropoff());
			reservationdto.setCustomerId(reservation.getCustomer().getCustomerId());
			reservationdto.setCarId(reservation.getCar().getCarId());
			reservationdto.setPaymentId(reservation.getPayment().getPaymentId());

			
			reservationDTOList.add(reservationdto);
		}
		return reservationDTOList;
	}

	@Override
	public List<ReservationDTO> getReservationDetailsForCustomer(int customerId) {
		List<Reservations> reservationsList=  reservationRepo.getReservationDetailsForCustomer(customerId);
		List<ReservationDTO> reservationDTOList = new ArrayList<>();
		for(Reservations reservation : reservationsList) {
			ReservationDTO reservationdto = new ReservationDTO();
			reservationdto.setReservationId(reservation.getResevationId());
			reservationdto.setReservationStatus(reservation.getReservationstatus());
			reservationdto.setDateOfReservation(reservation.getDateOfReservation());
			reservationdto.setDateOfPickup(reservation.getDateOfPickup());
			reservationdto.setDateOfDropoff(reservation.getDateOfDropoff());
			
			reservationDTOList.add(reservationdto);
		}
		return reservationDTOList;
	}
	
	
	
}

