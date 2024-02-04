package com.hexaware.roadready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
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
}
