package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.PaymentAndReservationDTO;
import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.CustomerIdentity;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.exceptions.InvalidPaymentException;
import com.hexaware.roadready.exceptions.PaymentNotFoundException;
import com.hexaware.roadready.repository.CarRepository;
import com.hexaware.roadready.repository.CustomerIdentityRepository;
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
	
	@Autowired
	CustomerIdentityRepository customerIdentityRepo;
	
	
	
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

	/*@Override
	public PaymentDTO makePayment(int customerId ,int carId , int reservationId ,PaymentDTO paymentdto ,LocalDate dateOfPickup , LocalDate dateOfdropoff) throws InvalidPaymentException {
		
	
		Payments payment = new Payments();
		Payments validPayment = new Payments();
		PaymentDTO validPaymentdto = new PaymentDTO();
		Cars car = carRepo.findById(carId).orElse(null);
		 Customers customer = customerRepo.findById(customerId).orElse(null);
		 
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
               carRepo.updateCarAvailability("unavailable", carId);
               carRepo.save(car);
		}
		else {
			throw new InvalidPaymentException("Please enter " + amountToBePaid + " rupees");
		}
		validPaymentdto.setPaymentId(validPayment.getPaymentId());
		validPaymentdto.setAmountPaid(validPayment.getAmountPaid());
		validPaymentdto.setModeOfPayment(validPayment.getModeOfPayment());
		validPaymentdto.setDateOfPayment(validPayment.getDateOfPayment());
		return validPaymentdto;
		
	}*/
	
	public PaymentAndReservationDTO makePaymentAndReservation(PaymentAndReservationDTO paymentAndReservationDTO) throws InvalidPaymentException {
		
		Payments payment = new Payments();
		Payments validPayment = new Payments();
		Reservations validReservation=new Reservations();
		PaymentAndReservationDTO validPaymentdto = new PaymentAndReservationDTO();
		
		
		Cars car = carRepo.findById(paymentAndReservationDTO.getCarId()).orElse(null);
		Customers customer = customerRepo.findById(paymentAndReservationDTO.getCustomerId()).orElse(null);
		 
		double dailyRate = car.getDailyRate();
		
		//payment.setPaymentId(paymentAndReservationDTO.getPaymentId());
		payment.setModeOfPayment(paymentAndReservationDTO.getModeOfPayment());
		payment.setDateOfPayment(LocalDate.now());
		payment.setAmountPaid(paymentAndReservationDTO.getAmountPaid());
		payment.setCustomer(customer);
		
		long totalDays = ChronoUnit.DAYS.between(paymentAndReservationDTO.getDateOfPickup(), paymentAndReservationDTO.getDateOfDropOff());
		double amountToBePaid = dailyRate * totalDays;
		
		boolean isValid=verifyCustomer(paymentAndReservationDTO.getCustomerId());
		
		if(paymentAndReservationDTO.getAmountPaid() ==  amountToBePaid && isValid ) {
               validPayment = paymentRepo.save(payment);
               Reservations reservation = new Reservations();
              // reservation.setResevationId(paymentAndReservationDTO.getResevationId());
               reservation.setReservationStatus("reserved");
               reservation.setDateOfPickup(paymentAndReservationDTO.getDateOfPickup());
               reservation.setDateOfDropoff(paymentAndReservationDTO.getDateOfDropOff());
               reservation.setDateOfReservation(LocalDate.now());
               reservation.setPayment(validPayment);
               reservation.setCustomer(customer);
               reservation.setCar(car);
               validReservation = reservationRepo.save(reservation);
               carRepo.updateCarAvailability("unavailable", paymentAndReservationDTO.getCarId());
             
		}
		else{
			throw new InvalidPaymentException("Please enter " + amountToBePaid + " rupees");
		}
		//validPaymentdto.setPaymentId(validPayment.getPaymentId());
		validPaymentdto.setAmountPaid(validPayment.getAmountPaid());
		validPaymentdto.setModeOfPayment(validPayment.getModeOfPayment());
		//validPaymentdto.setResevationId(validReservation.getResevationId());
		validPaymentdto.setDateOfPickup(validReservation.getDateOfPickup());
		validPaymentdto.setDateOfDropOff(validReservation.getDateOfDropoff());
		validPaymentdto.setCustomerId(paymentAndReservationDTO.getCustomerId());
		validPaymentdto.setCarId(paymentAndReservationDTO.getCarId());
		return validPaymentdto;
		
		
	}

	public boolean verifyCustomer(int customerId) {
		Optional<CustomerIdentity> customerIdentity =customerIdentityRepo.findByCustomerId(customerId);
		if(customerIdentity!=null) {
			return true;
		}
		else {
			return false;
		}
	}
		
	
}
