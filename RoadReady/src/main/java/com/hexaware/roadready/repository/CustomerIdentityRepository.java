package com.hexaware.roadready.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.roadready.entities.CustomerIdentity;

public interface CustomerIdentityRepository extends JpaRepository<CustomerIdentity,Long>{
  
	 void deleteByCustomerId(int customerId);
	 
	  Optional<CustomerIdentity> findByCustomerId(Long customerId);
}
