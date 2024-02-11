package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.dto.ReservationDTO;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.exceptions.InvalidPaymentException;
import com.hexaware.roadready.exceptions.PaymentNotFoundException;

public interface IPaymentService {
       
	List<PaymentDTO> viewPaymentHistory(int customerId)  throws  PaymentNotFoundException;
	
	public List<PaymentDTO> getPaymentDetailsForCustomer(int customerId)throws PaymentNotFoundException;
	
	public List<PaymentDTO> viewAllPayments() ;
	
	public PaymentDTO makePayment(int customerId , int carId , int reservationId ,PaymentDTO paymentdto ,LocalDate dateOfPickup , LocalDate dateOfdropoff ) throws InvalidPaymentException;
}
