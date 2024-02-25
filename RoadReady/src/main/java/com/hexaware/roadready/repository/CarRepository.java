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
	
	@Query("select c from Cars c where c.carStatus= 'available'")
    List<Cars> getAvailableCars();
	
	
	@Modifying
	@Query("UPDATE Cars c SET c.dailyRate = c.dailyRate * (1 - ?2 / 100.0) WHERE c.make = ?1")
	void discountOnCarPriceByMake(String make , double discountPrice);
	
	List<Cars> findByMake(String make);
	
	List<Cars> findByPassengerCapacity(int passengers);
	
	@Modifying
	@Query("update Cars c set c.carStatus = ?1 where c.carId = ?2")
	void updateCarStatusAfterCheckout(String carStatus , int carId);
	
	@Modifying
	@Query("update Cars c set c.carStatus =?1 where c.carId =?2")
	void updateCarAvailability(String carStatus , int carId);
	
	@Query("select c from Cars c where c.carStatus = 'maintenance'")
	List<Cars> carUnderMaintenance();
	
	
	List<Cars> findByLocation(String location);
	
	List<Cars> findBySpecification(String specification);
	
}
