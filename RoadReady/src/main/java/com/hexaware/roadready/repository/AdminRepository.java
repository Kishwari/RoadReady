package com.hexaware.roadready.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.roadready.entities.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Optional<Admin> findByUsername(String username);
	//Admin findByUsername(String username);

	 boolean existsByUsername(String username);
}
