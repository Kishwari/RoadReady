package com.hexaware.roadready.service;

import java.util.Date;
import java.util.List;

import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Feedback;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;



public interface ICustomerService {
	
	public List<Cars> getAvailableCars(); 
	
	List<Cars> searchCars(String location,String make,String model);
    
	
    ReservationDTO makeReservation(ReservationDTO reservation);
    
    String cancelReservation(int reservationId);
    
    ReservationDTO modifyReservation(int reservationId);
    
  
    
    void provideFeedback(Feedback feedback);
    
    List<Payments> viewPaymentHistory(int customerId);
    
    List<Reservations> viewReservations(int customerId);
 
    public CustomerDTO	updateCustomer(CustomerDTO customer);
}
