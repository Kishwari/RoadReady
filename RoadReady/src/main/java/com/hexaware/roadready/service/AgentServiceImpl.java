package com.hexaware.roadready.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class AgentServiceImpl implements IAgentService{

	@Override
	 public String completeCheckIn(int reservationId) {
        //step1 :  get reservation details by reservation id 
        //step2 : check whether pickup date is today or not 
		//step 3: check customer details by getting customer by customerId from reservation object that we retrieved from step 1
        //step 4 : if both 2 and 3 exist then return string as checked in and update in reservation as checkedin as completed(we need columns as checkin and checkout ) 
		//   Reservations reservation = ReservationRepository.findById(reservationId).orElse(null);
       //continue the logic
		return null;
        }

	public String completeCheckOut(int reservationId) {
         //step1 : after receiving the car from customer check if maintanace required 
		//if required update maintenance column in car entity as required else not required
		//step 2 :if requited update car availability as not available also
		// step 3 : update the checkout status in the reservation table  as completed
         //   Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        //  continue the logic
		
		return null;
        }

	
	

	@Override
	public CarDTO updateCarAvailability(int carId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO verifyIdentity(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}
     
	

	@Override
	public String carMaintenanceReport(String maintenance) {
		        
				//return a string with car object that has maintance as required
		return null;
	}

	@Override
	public Agent addAgent(AgentDTO agent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgentDTO getAgentById(int agentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Agent> getAllAgents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAgent(int agentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
