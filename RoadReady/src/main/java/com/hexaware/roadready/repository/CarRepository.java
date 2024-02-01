package com.hexaware.roadready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Cars;

@Repository
public interface CarRepository extends JpaRepository<Cars,Integer> {

}
