package com.hexaware.roadready.service;

import java.util.Date;
import java.util.List;

import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;



public interface ICustomerService {
	List<Cars> searchCars(String location, Date date, String make,String model);
    
    Reservations makeReservation(Customers customer, Cars car, Date dateOfPickup, Date dateOfDropoff);
    
    List<Reservations> manageReservations(Customers customer);
    
    boolean checkCarAvailability(String location, Date dateOfPickup , String make , String model);
    
    void provideFeedback(Customers customer, String feedback, int rating);
    
    List<Payments> viewPaymentHistory(Customers customer);
}
