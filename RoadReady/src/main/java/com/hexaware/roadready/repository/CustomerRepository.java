package com.hexaware.roadready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Integer>{

}
