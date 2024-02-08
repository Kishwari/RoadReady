package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.exceptions.InvalidPaymentException;

public interface IPaymentService {
       
	List<Payments> viewPaymentHistory(int customerId);
	
	public List<Payments> getPaymentDetailsForCustomer(int customerId);
	
	public List<PaymentDTO> viewAllPayments();
	
	public Payments makePayment(int customerId , int carId , int reservationId ,PaymentDTO paymentdto ,LocalDate dateOfPickup , LocalDate dateOfdropoff ) throws InvalidPaymentException;
}
