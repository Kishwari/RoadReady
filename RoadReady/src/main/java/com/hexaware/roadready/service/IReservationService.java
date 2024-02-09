package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.ReservationNotFoundException;

public interface IReservationService {
    
  //  Reservations makeReservation(ReservationDTO reservationdto);
    
    String cancelReservation(int reservationId);
    
    ReservationDTO modifyReservation(int reservationId ,LocalDate dateOfPickup , LocalDate dateOfDropoff) throws ReservationNotFoundException;
    
    List<ReservationDTO> viewReservations(int customerId);
    
    public List <ReservationDTO> viewAllReservations();
    
    public List<ReservationDTO> getReservationDetailsForCustomer(int customerId);
}
