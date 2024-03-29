package com.hexaware.roadready.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {


	
    @ExceptionHandler(CustomerNotFoundException.class)   
    @ResponseStatus(value=HttpStatus.NOT_FOUND , reason="Customer doesn't exist")
	public void handleCustomerNotFoundExp() {
    	  
      }
	@ResponseStatus(value=HttpStatus.NOT_FOUND , reason="Car doesn't exist")
    @ExceptionHandler(CarNotFoundException.class)      
	public void handleCarNotFoundExp() {
    	  
      }
	@ResponseStatus(value=HttpStatus.NOT_FOUND , reason="reservation details you are searching for doesnt exist")
    @ExceptionHandler(ReservationNotFoundException.class)      
	public void handleReservationNotFoundExp() {
    	  
      }
	@ResponseStatus(value=HttpStatus.NOT_FOUND , reason="payment details you are searching for doesnt exist")
    @ExceptionHandler(PaymentNotFoundException.class)      
	public void handlePaymentNotFoundExp() {
      }
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND , reason="Agent doesn't exist")
    @ExceptionHandler(AgentNotFoundException.class)      
	public void handleAgentNotFoundExp() {
    	  
      }
	@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE , reason="please enter a valid date")
    @ExceptionHandler(InvalidDateException.class)      
	public void handleInvalidDateExp() {
    	  
      }
	@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE , reason="please enter a valid payment")
    @ExceptionHandler(InvalidPaymentException.class)      
	public void handleInvalidPaymentExp() {
    	  
      }
}
