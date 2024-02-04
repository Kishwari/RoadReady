package com.hexaware.roadready.dto;

import java.time.LocalDate;
import java.util.Date;

public class ReservationDTO {

	private int reservationId;
	private String reservationStatus;
	private LocalDate dateOfReservation;
	private LocalDate dateOfPickup;
	private  LocalDate dateOfDropoff;
	
	// constructor
	
	public ReservationDTO() {
		super();
	}
	
	// parameterized constructor 
	
	public ReservationDTO(int reservationId, String reservationStatus, LocalDate dateOfReservation, LocalDate dateOfPickup,
			LocalDate dateOfDropoff) {
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
	public LocalDate getDateOfReservation() {
		return dateOfReservation;
	}
	public void setDateOfReservation(LocalDate dateOfReservation) {
		this.dateOfReservation = dateOfReservation;
	}
	public LocalDate getDateOfPickup() {
		return dateOfPickup;
	}
	public void setDateOfPickup(LocalDate dateOfPickup) {
		this.dateOfPickup = dateOfPickup;
	}
	public LocalDate getDateOfDropoff() {
		return dateOfDropoff;
	}
	public void setDateOfDropoff(LocalDate dateOfDropoff) {
		this.dateOfDropoff = dateOfDropoff;
	}
	@Override
	public String toString() {
		return "ReservationDTO [reservationId=" + reservationId + ", reservationStatus=" + reservationStatus
				+ ", dateOfReservation=" + dateOfReservation + ", dateOfPickup=" + dateOfPickup + ", dateOfDropoff="
				+ dateOfDropoff + "]";
	}
	
	
}
