package com.hexaware.roadready.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Customers;


@Repository
public interface CustomerRepository extends JpaRepository<Customers,Integer>{
	
	Optional<Customers> findByUsername(String username);
//Customers findByUsername(String username);

boolean existsByUsername(String username);
}
