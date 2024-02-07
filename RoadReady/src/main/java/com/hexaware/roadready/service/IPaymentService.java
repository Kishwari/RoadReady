package com.hexaware.roadready.service;

import java.util.List;

import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.entities.Payments;

public interface IPaymentService {
       
	List<Payments> viewPaymentHistory(int customerId);
	
	public List<Payments> getPaymentDetailsForCustomer(int customerId);
	
	public List<PaymentDTO> viewAllPayments();
}
