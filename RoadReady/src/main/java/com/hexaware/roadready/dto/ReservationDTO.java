package com.hexaware.roadready.dto;

import java.util.Date;

public class ReservationDTO {

	private int reservationId;
	private String reservationStatus;
	private Date dateOfReservation;
	private Date dateOfPickup;
	private  Date dateOfDropoff;
	
	// constructor
	
	public ReservationDTO() {
		super();
	}
	
	// parameterized constructor 
	
	public ReservationDTO(int reservationId, String reservationStatus, Date dateOfReservation, Date dateOfPickup,
			Date dateOfDropoff) {
		super();
		this.reservationId = reservationId;
		this.reservationStatus = reservationStatus;
		this.dateOfReservation = dateOfReservation;
		this.dateOfPickup = dateOfPickup;
		this.dateOfDropoff = dateOfDropoff;
	}
	
	// getters and setters
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public String getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	public Date getDateOfReservation() {
		return dateOfReservation;
	}
	public void setDateOfReservation(Date dateOfReservation) {
		this.dateOfReservation = dateOfReservation;
	}
	public Date getDateOfPickup() {
		return dateOfPickup;
	}
	public void setDateOfPickup(Date dateOfPickup) {
		this.dateOfPickup = dateOfPickup;
	}
	public Date getDateOfDropoff() {
		return dateOfDropoff;
	}
	public void setDateOfDropoff(Date dateOfDropoff) {
		this.dateOfDropoff = dateOfDropoff;
	}
	@Override
	public String toString() {
		return "ReservationDTO [reservationId=" + reservationId + ", reservationStatus=" + reservationStatus
				+ ", dateOfReservation=" + dateOfReservation + ", dateOfPickup=" + dateOfPickup + ", dateOfDropoff="
				+ dateOfDropoff + "]";
	}
	
	
}
