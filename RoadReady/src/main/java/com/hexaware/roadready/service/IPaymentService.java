package com.hexaware.roadready.service;

import java.util.List;

import com.hexaware.roadready.dto.PaymentAndReservationDTO;
import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.dto.PaymentListDTO;
import com.hexaware.roadready.exceptions.InvalidPaymentException;
import com.hexaware.roadready.exceptions.PaymentNotFoundException;

public interface IPaymentService {
       
	List<PaymentListDTO> viewPaymentHistory(int customerId)  throws  PaymentNotFoundException;
	
	public List<PaymentDTO> getPaymentDetailsForCustomer(int customerId)throws PaymentNotFoundException;
	
	//public List<PaymentDTO> viewAllPayments() ;
	
	public List<PaymentListDTO> viewAllPayments() ;
	
	//public PaymentDTO makePayment(int customerId , int carId , int reservationId ,PaymentDTO paymentdto ,LocalDate dateOfPickup , LocalDate dateOfdropoff ) throws InvalidPaymentException, CarNotFoundException;
    
	public PaymentAndReservationDTO makePaymentAndReservation(PaymentAndReservationDTO paymentAndReservationDTO) throws InvalidPaymentException;
}
