package com.hexaware.roadready.service;

import java.util.List;

import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Reservations;

public interface IReservationService {
    
    ReservationDTO makeReservation(ReservationDTO reservation);
    
    String cancelReservation(int reservationId);
    
    ReservationDTO modifyReservation(ReservationDTO reservation);
    
    List<Reservations> viewReservations(int customerId);
    
    public List <ReservationDTO> viewAllReservations();
    
    public List<Reservations> getReservationDetailsForCustomer(int customerId);
}
