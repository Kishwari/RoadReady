package com.hexaware.roadready.restcontroller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.InvalidPaymentException;
import com.hexaware.roadready.exceptions.PaymentNotFoundException;
import com.hexaware.roadready.service.IPaymentService;

@RestController
@RequestMapping("/roadready/payments")
public class PaymentRestController {

	Logger logger=LoggerFactory.getLogger(PaymentRestController.class);

	
	@Autowired
	IPaymentService paymentService;
	

	@GetMapping("/getPaymentsOfCustomer/{customerId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<PaymentDTO> getPaymentDetailsForCustomer(@PathVariable int customerId){
    	logger.warn("Might throw PaymentNotFoundException ");
		List<PaymentDTO> payments = new ArrayList<PaymentDTO>();
		try {
			payments = paymentService.getPaymentDetailsForCustomer(customerId);
		} catch (PaymentNotFoundException e) {
			e.printStackTrace();
		}
    	logger.info("Payment details of customer with Id : "+customerId);
		return payments;
	}
	
	 @GetMapping("/getAllPayments")
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	    public List<PaymentDTO> viewAllPayments(){
	    	logger.info("Generating all payment details");
	    	return paymentService.viewAllPayments();
	    }
	    
	 @GetMapping("/viewPaymentHistory/{customerId}")
	 @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
	   public List<PaymentDTO> viewPaymentHistory(@PathVariable int customerId){
		   List<PaymentDTO> payments=new ArrayList<PaymentDTO>();
		try {
			payments = paymentService.viewPaymentHistory(customerId);
		} catch (PaymentNotFoundException e) {
			e.printStackTrace();
		}
		   return payments;
	}
	 

	 @PostMapping("/makePayment/{customerId}/{carId}/{reservationId}/{dateOfPickup}/{dateOfDropoff}")
	 @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
	   public PaymentDTO makePayment(@PathVariable int customerId , @PathVariable int carId ,@PathVariable int reservationId ,  @PathVariable LocalDate dateOfPickup , @PathVariable LocalDate dateOfDropoff ,@RequestBody PaymentDTO paymentdto  ) {

		   PaymentDTO payment = new PaymentDTO();
		try {
			payment = paymentService.makePayment(customerId , carId , reservationId ,paymentdto, dateOfPickup , dateOfDropoff);
		} catch (InvalidPaymentException e) {
			
			e.printStackTrace();
		} catch (CarNotFoundException e) {
			
			e.printStackTrace();
		}
		   
		   return payment;
	   }
}
