package com.hexaware.roadready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Payments;

@Repository
public interface PaymentRepository extends JpaRepository<Payments,Integer> {

}
