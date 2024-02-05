package com.hexaware.roadready.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Integer>{
	
	
}
