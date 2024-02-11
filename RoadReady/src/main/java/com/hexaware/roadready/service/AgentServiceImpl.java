package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.repository.AgentRepository;
import com.hexaware.roadready.repository.CarRepository;
import com.hexaware.roadready.repository.CustomerRepository;
import com.hexaware.roadready.repository.ReservationRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
	
	@Autowired
	CarRepository carRepo;
	
	@Autowired
   PasswordEncoder passwordEncoder;
	
	@PersistenceContext
    private EntityManager entityManager;

	
	@Override
	 public String completeCheckIn(int reservationId) {
        //step1 :  get reservation details by reservation id 
		Reservations reservation = reservationRepo.findById(reservationId).orElse(null);
		if (reservation != null) {
	        // Step 2: Check whether pickup date is today or not 
	        if (reservation.getDateOfPickup().equals(LocalDate.now())) {
	            // Step 3: Check customer details 
	            Customers customer = reservation.getCustomer();
	            Customers checkCustomer = customerRepo.findById(customer.getCustomerId()).orElse(null);
	            if (checkCustomer != null && checkCustomer.equals(customer)) {
	                // Step 4: Check-in completed successfully 
	                return "Check-in completed successfully";
	            }
	        }
	    }
	    // Step 5: Check-in failed 
	    return "Check-in failed";
	}
        

	public String completeCheckOut(int reservationId , String carStatus) {
         
		 Reservations reservation = reservationRepo.findById(reservationId).orElse(null);
		 Cars car  = reservation.getCar();
		 int carId = car.getCarId();
	     carRepo.updateCarStatusAfterCheckout(carStatus,carId);
	     
	       // Clear entity manager cache
	      entityManager.clear();
	     Cars updatedCar = carRepo.findById(carId).orElse(null);
		
		String updatedCarStatus = updatedCar.getCarStatus();
		return  "checkout completed successfully and car status updated to " + updatedCarStatus;
        }

	
	

	@Override
	public Cars updateCarAvailability(String carStatus ,int carId) {
		carRepo.updateCarAvailability(carStatus, carId);
		return carRepo.findById(carId).orElse(null);
		
	}

	@Override
	public CustomerDTO verifyIdentity(int customerId) {
		Customers customer =customerRepo.findById(customerId).orElse(null);
		CustomerDTO customerdto=new CustomerDTO();
		customerdto.setCustomerId(customer.getCustomerId());
		customerdto.setFirstName(customer.getFirstName());
		customerdto.setLastName(customer.getLastName());
		customerdto.setEmailAddress(customer.getEmailAddress());
		customerdto.setUsername(customer.getUsername());
		customerdto.setPassword(customer.getPassword());
		customerdto.setPhoneNumber(customer.getPhoneNumber());
		return customerdto;
		//return customer;
	}
     
	

	@Override
	public String carMaintenanceReport() {
		List<Cars> carList = carRepo.carUnderMaintenance();    
		StringBuilder report = new StringBuilder();
	    report.append("Cars under maintenance:\n");
	    for (Cars car : carList) {
	        report.append(car.toString()).append("\n"); 
	    }
	    return report.toString();
		

	}

	@Override
	public Agent addAgent(AgentDTO agentdto) {
		Agent agent = new Agent();
		agent.setAgentId(agentdto.getAgentId());
		agent.setUsername(agentdto.getUsername());
		//agent.setPassword(agentdto.getPassword());
		agent.setPassword(passwordEncoder.encode(agentdto.getPassword()));
		agent.setRole("ROLE_AGENT");
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
		agent.setRole("ROLE_AGENT");
		agentRepo.save(agent);
		}
		return agent;
	}
}