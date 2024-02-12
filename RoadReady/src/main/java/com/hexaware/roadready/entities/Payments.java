package com.hexaware.roadready.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Payments {
	
	@Id
	private int paymentId;                                                             
	@NotNull(message="cannot be null")
	private double amountPaid;              
	@NotNull(message="cannot be null")
	private LocalDate dateOfPayment ;
	@NotBlank(message="cannot be blank")
	@Pattern(regexp = "^(upi|creditcard|debitcard)$", message = "Mode of payment must be 'upi', 'credit', or 'debit'.")
	private String modeOfPayment ;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customers customer;
	
	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;
	
	public Payments() {
		super();
		
	}
	
	public Payments(int paymentId, double amountPaid, LocalDate dateOfPayment, String modeOfPayment) {
		super();
		this.paymentId = paymentId;
		this.amountPaid = amountPaid;
		this.dateOfPayment = dateOfPayment;
		this.modeOfPayment = modeOfPayment;
	}
	
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public LocalDate getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(LocalDate dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	} 
	
	
	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId +  " , amountPaid=" + amountPaid
				+ ", dateOfPayment=" + dateOfPayment + ", modeOfPayment=" + modeOfPayment + "]";
	}

	

}