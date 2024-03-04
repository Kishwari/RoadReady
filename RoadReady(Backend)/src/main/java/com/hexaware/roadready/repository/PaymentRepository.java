package com.hexaware.roadready.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Payments;

@Repository
public interface PaymentRepository extends JpaRepository<Payments,Integer> {
	
	
	@Query("select SUM(p.amountPaid) from Payments p where p.dateOfPayment between ?1 and ?2")
    Double findRevenueBetweenDates(LocalDate startDate, LocalDate endDate);
	
	//@Query("select SUM(p.amountPaid) from payments p where p.customerId=?1")
	@Query("SELECT SUM(p.amountPaid) FROM Payments p WHERE p.customer.id = ?1")
    Double findRevenueBycustomerId(int customerId);
	
	@Query("select SUM(p.amountPaid) from Payments p")
    Double findTotalRevenue();
	
	//@Query("select p from Payments p where customerId = ?1 order by p.dateOfPayment desc")
	@Query(value = "SELECT * FROM Payments WHERE customer_id = ?1 ORDER BY date_of_payment DESC", nativeQuery = true)
	public List<Payments> viewPaymentHistory(int customerId);
	
	//@Query("select p from Payments p where p.customerId = ?1 order by p.dateOfPayment desc")
	@Query(value = "SELECT * FROM Payments WHERE customer_id = ?1 ORDER BY date_of_payment DESC", nativeQuery = true)
	public List<Payments> getPaymentDetailsForCustomer(int customerId);
	
	
}
