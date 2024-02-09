package com.hexaware.roadready.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.roadready.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
