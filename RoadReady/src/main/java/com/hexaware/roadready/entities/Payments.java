package com.hexaware.roadready.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Payments {

	@Id
	private int paymentId;
	private double amountPaid;
	private Date dateOfPayment;
	private String modeOfPayment;
	
	// Customers to payment (1-M)
	@ManyToOne
	@JoinColumn(name="cust_id")
	private Customers customers;
	
	
	@OneToOne
	private Reservations reservations;
	
	public Payments() {
		super();
	}


	public Payments(int paymentId, double amountPaid, Date dateOfPayment, String modeOfPayment) {
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


	public Date getDateOfPayment() {
		return dateOfPayment;
	}


	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}


	public String getModeOfPayment() {
		return modeOfPayment;
	}


	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}


	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId  + ", amountPaid=" + amountPaid
				+ ", dateOfPayment=" + dateOfPayment + ", modeOfPayment=" + modeOfPayment + "]";
	}
	
	
}
