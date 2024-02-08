package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.repository.AgentRepository;
import com.hexaware.roadready.repository.CustomerRepository;
import com.hexaware.roadready.repository.ReservationRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class AgentServiceImpl implements IAgentService{
	
	@Autowired
	AgentRepository agentRepo;
	@Autowired
	ReservationRepository reservationRepo;
    
	@Autowired
	CustomerRepository customerRepo;

	
	@Override
	 public String completeCheckIn(int reservationId) {
        //step1 :  get reservation details by reservation id 
		Reservations reservation = reservationRepo.findById(reservationId).orElse(null);
		Customers customer = reservation.getCustomer();
	     Customers checkCustomer  = customerRepo.findById(customer.getCustomerId()).orElse(null);
        //step2 : check whether pickup date is today or not 
	   //step 3: check customer details by getting customer by customerId from reservation object that we retrieved from step 1
	     
		if(reservation.getDateOfPickup()==LocalDate.now() && checkCustomer == customer) {
			
			return "checkin completed successfully";
		
		}
        //step 4 : if both 2 and 3 exist then return string as checked in and update in reservation as checkedin as completed(we need columns as checkin and checkout ) 
		//   Reservations reservation = ReservationRepository.findById(reservationId).orElse(null);
       //continue the logic
		else {
			return " check in failed";
		}
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
	public Agent addAgent(AgentDTO agentdto) {
		Agent agent = new Agent();
		agent.setAgentId(agentdto.getAgentId());
		agent.setUsername(agentdto.getUsername());
		agent.setPassword(agentdto.getPassword());
		agentRepo.save(agent);
		return agent;
	}

	@Override
	public AgentDTO getAgentById(int agentId) {
		Agent agent = agentRepo.findById(agentId).orElse(null);
		AgentDTO agentdto = new AgentDTO ();
		agentdto.setAgentId(agent.getAgentId());
		agentdto.setUsername(agent.getUsername());
		agentdto.setPassword(agent.getPassword());
		return agentdto;
	}

	@Override
	public List<Agent> getAllAgents() {
		return agentRepo.findAll();
	}

	@Override
	public String deleteAgent(int agentId) {
		agentRepo.deleteById(agentId);
		Agent agent = agentRepo.findById(agentId).orElse(null);

		if(agent==null) {
		   return  "agent with id " + agentId + "deleted succesfully";
		}
		else {
			return " agent deletion unsuccessfull";
		}
	}

	@Override
	public Agent updateAgent(int agentId , AgentDTO agentdto) {
		Agent agent = agentRepo.findById(agentId).orElse(null);
		if(agent!=null) {
		agent.setAgentId(agentdto.getAgentId());
		agent.setUsername(agentdto.getUsername());
		agent.setPassword(agentdto.getPassword());
		agentRepo.save(agent);
		}
		return agent;
	}
}