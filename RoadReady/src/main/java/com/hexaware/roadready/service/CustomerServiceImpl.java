package com.hexaware.roadready.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Feedback;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
    
	@Autowired
	CustomerRepository repo;
	
	@Override
	public List<Cars> getAvailableCars() {
		
		return repo.getAvailableCars();
	}
	@Override
	public List<Cars> searchCars(String location, String make, String model) {
        List<Cars> availableCars = repo.getAvailableCars();
        return availableCars.stream()
                .filter(car -> car.getMake().equals(make) && car.getModel().equals(model)
                && car.getLocation().equals(location) ) .collect(Collectors.toList());
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customer) {
		// TODO Auto-generated method stub
		return null;
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
	public Feedback provideFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Payments> viewPaymentHistory(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Reservations> viewReservations(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
