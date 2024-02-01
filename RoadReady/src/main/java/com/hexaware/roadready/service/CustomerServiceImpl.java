package com.hexaware.roadready.service;

import java.util.Date;
import java.util.List;

import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;

public class CustomerServiceImpl implements ICustomerService {
    
	@Override
	public List<Cars> searchCars(String location, Date date, String make, String model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservations makeReservation(Customers customer, Cars car, Date dateOfPickup, Date dateOfDropoff) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservations> manageReservations(Customers customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkCarAvailability(String location, Date dateOfPickup, String make, String model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void provideFeedback(Customers customer, String feedback, int rating) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Payments> viewPaymentHistory(Customers customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
