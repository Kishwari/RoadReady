package com.hexaware.roadready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Reservations;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations,Integer>{
      
   //
}
