package com.hexaware.roadready.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Payments;

@Repository
public interface PaymentRepository extends JpaRepository<Payments,Integer> {
	// Custom queries for specific report needs
	//report for total revenue between dates
    //  List<Payments> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
	//report for total revenue by specific customer
    //  List<Payments> findByUserId(Long userId);
	//report for total revenue
    // List<Payments> findByTotalRevenue();
	
	//@Query("select p from Payments p where customerId = ?1 order by p.dateOfPayment desc")
	@Query(value = "SELECT * FROM Payments WHERE customerId = ?1 ORDER BY dateOfPayment DESC", nativeQuery = true)
	public List<Payments> viewPaymentHistory(int customerId);
	
	//@Query("select p from Payments p where p.customerId = ?1 order by p.dateOfPayment desc")
	@Query(value = "SELECT * FROM Payments WHERE customerId = ?1 ORDER BY dateOfPayment DESC", nativeQuery = true)
	public List<Payments> getPaymentDetailsForCustomer(int customerId);
}
