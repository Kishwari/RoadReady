package com.hexaware.roadready.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.repository.PaymentRepository;


public class PaymentServiceImpl implements IPaymentService {
	
	@Autowired
	PaymentRepository paymentRepo;
	
	@Override
	public List<PaymentDTO> viewAllPayments() {
		 List<Payments> paymentList = paymentRepo.findAll();
		    List<PaymentDTO> paymentDTOList = new ArrayList<>();
		    for (Payments payment : paymentList) {
		        PaymentDTO paymentDTO = new PaymentDTO();
		        paymentDTO.setPaymentId(payment.getPaymentId());
		        paymentDTO.setAmountPaid(payment.getAmountPaid());
		        paymentDTO.setDateOfPayment(payment.getDateOfPayment());
		        paymentDTO.setModeOfPayment(payment.getModeOfPayment());

		        paymentDTOList.add(paymentDTO);
		    }
		    return paymentDTOList;
	}

	@Override
	public List<Payments> viewPaymentHistory(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payments> getPaymentDetailsForCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}
}
