package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.CustomerIdentity;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.AgentNotFoundException;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.exceptions.CustomerIdentityNotFoundException;
import com.hexaware.roadready.repository.AgentRepository;
import com.hexaware.roadready.repository.CarRepository;
import com.hexaware.roadready.repository.CustomerIdentityRepository;
import com.hexaware.roadready.repository.CustomerRepository;
import com.hexaware.roadready.repository.ReservationRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AgentServiceImpl implements IAgentService{
	
	Logger logger=LoggerFactory.getLogger(AgentServiceImpl.class);

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
	
	@Autowired
	CustomerIdentityRepository customerIdentityRepo;
	
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
	            	reservation.setReservationStatus("check-in completed");
	            	reservationRepo.save(reservation);
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
	     reservation.setReservationStatus("check-out completed");
	     reservationRepo.save(reservation);
	     
	      // Clear entity manager cache
	      entityManager.clear();
	      Cars updatedCar = carRepo.findById(carId).orElse(null);
		
		String updatedCarStatus = updatedCar.getCarStatus();
		reservation.setReservationStatus("check-out completed");
    	reservationRepo.save(reservation);
		return  "checkout completed successfully and car status updated to " + updatedCarStatus;
        }

	
	

	@Override
	public CarDTO updateCarAvailability(String carStatus ,int carId)  throws CarNotFoundException
	{      

		carRepo.updateCarAvailability(carStatus, carId);
	     
		logger.info(carId+" for this car Id , status has been Updated ");
		
		Cars car= carRepo.findById(carId).orElse(null);
		CarDTO cardto=new CarDTO();
		cardto.setCarId(car.getCarId());
		cardto.setMake(car.getMake());
		cardto.setModel(car.getModel());
		cardto.setCarStatus(car.getCarStatus());
		cardto.setSpecifications(car.getSpecification());
		cardto.setLocation(car.getLocation());
		cardto.setPassengerCapacity(car.getPassengerCapacity());
		cardto.setDailyRate(car.getDailyRate());
		return cardto;
		 
		
	}

	@Override
	public ResponseEntity<byte[]> verifyIdentity(int customerId) throws CustomerIdentityNotFoundException {
		
		 Optional<CustomerIdentity> optionalPdf = customerIdentityRepo.findByCustomerId(customerId);
         if (optionalPdf.isPresent()) {
         	CustomerIdentity pdf = optionalPdf.get();
             byte[] content = pdf.getContent();         //  'getContent' returns the raw PDF data
             return ResponseEntity.ok()
                     .contentType(MediaType.APPLICATION_PDF)
                     .body(content);
         } else {
             return ResponseEntity.notFound().build();
         }
	}
		
		/*CustomerIdentity customerIdentity= new CustomerIdentity();
		customerIdentity=customerIdentityRepo.findByCustomerId(customerId);
		if(customerIdentity.getContent()==null) {
			throw new CustomerIdentityNotFoundException("customer identity for customer"+customerId+"doesnt exist");
		}
		else {
			return "customer identity verified";
		}
		}*/
		
		/*CustomerDTO customerdto=new CustomerDTO();
		customerdto.setCustomerId(customer.getCustomerId());
		customerdto.setFirstName(customer.getFirstName());
		customerdto.setLastName(customer.getLastName());
		customerdto.setEmailAddress(customer.getEmailAddress());
		customerdto.setUsername(customer.getUsername());
		customerdto.setPassword(customer.getPassword());
		customerdto.setPhoneNumber(customer.getPhoneNumber());*/
		
		
		
	
     
	

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

		logger.info("New Agent added");

		agent.setPassword(passwordEncoder.encode(agentdto.getPassword()));
		agent.setRole("ROLE_AGENT");

		agentRepo.save(agent);
		return agent;
	}

	@Override
	public AgentDTO getAgentById(int agentId) throws AgentNotFoundException {
		Agent agent = agentRepo.findById(agentId).orElse(null);
		if(agent!=null) {
		AgentDTO agentdto = new AgentDTO ();
		agentdto.setAgentId(agent.getAgentId());
		agentdto.setUsername(agent.getUsername());
		agentdto.setPassword(agent.getPassword());
		return agentdto;
		}
		throw new AgentNotFoundException("agnet with id " + agentId +" not found");
		
	}

	@Override
	public List<Agent> getAllAgents() {
		logger.info("Generating list of agents");
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