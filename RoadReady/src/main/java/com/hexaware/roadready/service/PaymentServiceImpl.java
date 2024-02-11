package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.InvalidPaymentException;
import com.hexaware.roadready.exceptions.PaymentNotFoundException;
import com.hexaware.roadready.repository.CarRepository;
import com.hexaware.roadready.repository.CustomerRepository;
import com.hexaware.roadready.repository.PaymentRepository;
import com.hexaware.roadready.repository.ReservationRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {
	
	@Autowired
	PaymentRepository paymentRepo;
	
	@Autowired
	CarRepository carRepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	
	
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
	public List<PaymentDTO> viewPaymentHistory(int customerId) throws  PaymentNotFoundException
 {
		List<Payments> paymentList = paymentRepo.viewPaymentHistory(customerId);
		if(paymentList.isEmpty()) {
			   throw new PaymentNotFoundException("Payment doesn't exist");

		}
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
	public List<PaymentDTO> getPaymentDetailsForCustomer(int customerId)throws PaymentNotFoundException {
		
		List<Payments> paymentList = paymentRepo.getPaymentDetailsForCustomer(customerId);
		if(paymentList.isEmpty()) {
			throw new PaymentNotFoundException("Payment doesnt exist");
		}
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
	public PaymentDTO makePayment(int customerId ,int carId , int reservationId ,PaymentDTO paymentdto ,LocalDate dateOfPickup , LocalDate dateOfdropoff) throws InvalidPaymentException {
		Payments payment = new Payments();
		Payments validPayment = new Payments();
		PaymentDTO validPaymentdto = new PaymentDTO();
		Cars car = new Cars();
		car = carRepo.findById(carId).orElse(null);
		Customers customer = new Customers();
		customer = customerRepo.findById(customerId).orElse(null);
		double dailyRate = car.getDailyRate();
		
		payment.setPaymentId(paymentdto.getPaymentId());
		payment.setModeOfPayment(paymentdto.getModeOfPayment());
		payment.setDateOfPayment(paymentdto.getDateOfPayment());
		payment.setAmountPaid(paymentdto.getAmountPaid());
		payment.setCustomer(customer);
		long totalDays = ChronoUnit.DAYS.between(dateOfPickup, dateOfdropoff);
		double amountToBePaid = dailyRate * totalDays;
		if(paymentdto.getAmountPaid() ==  amountToBePaid ) {
               validPayment = paymentRepo.save(payment);
               Reservations reservation = new Reservations();
               reservation.setResevationId(reservationId);
               reservation.setReservationStatus("reserved");
               reservation.setDateOfPickup(dateOfPickup);
               reservation.setDateOfDropoff(dateOfdropoff);
               reservation.setDateOfReservation(LocalDate.now());
               reservation.setPayment(validPayment);
               reservation.setCustomer(customer);
               reservation.setCar(car);
               reservationRepo.save(reservation);
		}
		else {
			throw new InvalidPaymentException("Please enter " + amountToBePaid + " rupees");
		}
		validPaymentdto.setPaymentId(validPayment.getPaymentId());
		validPaymentdto.setAmountPaid(validPayment.getAmountPaid());
		validPaymentdto.setModeOfPayment(validPayment.getModeOfPayment());
		validPaymentdto.setDateOfPayment(validPayment.getDateOfPayment());
		return validPaymentdto;
		
	}
}
