package com.hexaware.roadready.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.entities.Cars;

@Repository
public interface CarRepository extends JpaRepository<Cars,Integer> {
	
	@Query("select c from Cars c where c.carStatus= 'available' ")
    List<Cars> getAvailableCars();
	
	
	@Modifying
	@Query("UPDATE Cars c SET c.dailyRate = ?2 WHERE c.id = ?1")
	CarDTO discountOnCarPrice(int CarId , double discountPrice);
	
	
}
