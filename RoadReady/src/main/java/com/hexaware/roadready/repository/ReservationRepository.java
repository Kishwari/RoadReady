package com.hexaware.roadready.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations,Integer>{
      
	@Query(value = "SELECT r FROM Reservations r WHERE r.customer.id = ?1 ORDER BY dateOfReservation DESC")
	public List<Reservations> viewReservationHistory(int customerId);
	
	//@Query("select p from Payments p where p.customerId = ?1 order by p.dateOfPayment desc")
	@Query(value = "SELECT r FROM Reservations r WHERE r.customer.id = ?1 ORDER BY dateOfReservation DESC")
	public List<Reservations> getReservationDetailsForCustomer(int customerId);
	
	
}
