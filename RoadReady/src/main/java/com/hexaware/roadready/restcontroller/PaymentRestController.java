package com.hexaware.roadready.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.PaymentAndReservationDTO;
import com.hexaware.roadready.dto.PaymentDTO;
import com.hexaware.roadready.dto.PaymentListDTO;
import com.hexaware.roadready.exceptions.InvalidPaymentException;
import com.hexaware.roadready.exceptions.PaymentNotFoundException;
import com.hexaware.roadready.service.ICustomerService;
import com.hexaware.roadready.service.IPaymentService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/roadready/payments")
public class PaymentRestController {

	Logger logger=LoggerFactory.getLogger(PaymentRestController.class);

	
	@Autowired
	IPaymentService paymentService;
	
	@Autowired
	ICustomerService customerService;
	

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
	    public List<PaymentListDTO> viewAllPayments(){
	    	logger.info("Generating all payment details");
	    	return paymentService.viewAllPayments();
	    }
	    
	 @GetMapping("/viewPaymentHistory/{customerId}")
	 @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
	   public List<PaymentListDTO> viewPaymentHistory(@PathVariable int customerId){
		   List<PaymentListDTO> payments=new ArrayList<PaymentListDTO>();
		try {
			payments = paymentService.viewPaymentHistory(customerId);
		} catch (PaymentNotFoundException e) {
			e.printStackTrace();
		}
		   return payments;
	}
	 

	 @PostMapping("/makePaymentAndReservation")
	 @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
	 public PaymentAndReservationDTO makePaymentAndReservation(@RequestBody PaymentAndReservationDTO paymentAndReservationDTO) {
		 PaymentAndReservationDTO newPaymentAndReservationDTO= new PaymentAndReservationDTO();
		 try{
			 newPaymentAndReservationDTO=paymentService.makePaymentAndReservation(paymentAndReservationDTO);
		     customerService.generateInvoicePdf(paymentAndReservationDTO);
		 }
		 catch(InvalidPaymentException e) {
			 e.printStackTrace();
		 }
		 return newPaymentAndReservationDTO;
		 
		 
	 }
}
