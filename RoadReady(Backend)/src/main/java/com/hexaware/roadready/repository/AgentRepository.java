package com.hexaware.roadready.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.roadready.entities.Agent;


@Repository
public interface AgentRepository extends JpaRepository<Agent,Integer>{

	Optional<Agent> findByUsername(String username);
	

	boolean existsByUsername(String username);
}
