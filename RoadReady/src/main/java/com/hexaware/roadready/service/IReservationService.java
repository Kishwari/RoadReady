package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Reservations;

public interface IReservationService {
    
  //  Reservations makeReservation(ReservationDTO reservationdto);
    
    String cancelReservation(int reservationId);
    
    Reservations modifyReservation(int reservationId ,LocalDate dateOfPickup , LocalDate dateOfDropoff);
    
    List<Reservations> viewReservations(int customerId);
    
    public List <ReservationDTO> viewAllReservations();
    
    public List<Reservations> getReservationDetailsForCustomer(int customerId);
}
