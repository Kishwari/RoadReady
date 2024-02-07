package com.hexaware.roadready.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.repository.ReservationRepository;

public class ReservationServiceImpl implements IReservationService{
	
	@Autowired
	ReservationRepository reservationRepo;
	
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

	@Override
	public ReservationDTO makeReservation(ReservationDTO reservation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelReservation(int reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservationDTO modifyReservation(ReservationDTO reservation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservations> viewReservations(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservations> getReservationDetailsForCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}
}
