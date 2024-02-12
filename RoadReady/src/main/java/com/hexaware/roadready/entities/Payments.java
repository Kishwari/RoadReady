package com.hexaware.roadready.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Payments {
	
	@Id
	private int paymentId;                                                             
	@NotBlank
	private double amountPaid;              
	@NotBlank
	private LocalDate dateOfPayment ;
	@NotBlank
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
	
	public Payments(int paymentId, int reservationId, double amountPaid, LocalDate dateOfPayment, String modeOfPayment) {
		super();
		this.paymentId = paymentId;
		//this.reservationId = reservationId;
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
	//public int getReservationId() {
	//	return reservationId;
	//}
	//public void setReservationId(int reservationId) {
		//this.reservationId = reservationId;
	//}
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