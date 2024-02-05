package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;
import com.hexaware.roadready.exceptions.CarNotFoundException;
import com.hexaware.roadready.repository.AgentRepository;
import com.hexaware.roadready.repository.CarRepository;
import com.hexaware.roadready.repository.CustomerRepository;
import com.hexaware.roadready.repository.PaymentRepository;
import com.hexaware.roadready.repository.ReservationRepository;

import jakarta.transaction.Transactional;


@Transactional
@Service
public class AdminServiceImpl implements IAdminService {
    
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	CarRepository carRepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	PaymentRepository paymentRepo;
	
	@Autowired
	AgentRepository agentRepo;
	
	@Override
	public Customers addCustomer(CustomerDTO customerdto) {
		Customers customer = new Customers();
		customer.setCustomerId(customerdto.getCustomerId());
		customer.setFirstName(customerdto.getFirstName());
		customer.setLastName(customerdto.getLastName());
		customer.setEmailAddress(customerdto.getEmailAddress());
		customer.setUsername(customerdto.getUsername());
		customer.setPassword(customerdto.getPassword());
		customer.setPhoneNumber(customerdto.getPhoneNumber());
		return customerRepo.save(customer);
	}

	@Override
	public CustomerDTO getCustomerById(int customerId) {
		Customers customer = customerRepo.findById(customerId).orElse(null);
		CustomerDTO customerdto=new CustomerDTO();
		customerdto.setCustomerId(customer.getCustomerId());
		customerdto.setFirstName(customer.getFirstName());
		customerdto.setLastName(customer.getLastName());
		customerdto.setEmailAddress(customer.getEmailAddress());
		customerdto.setUsername(customer.getUsername());
		customerdto.setPassword(customer.getPassword());
		customerdto.setPhoneNumber(customer.getPhoneNumber());
		return customerdto;
	}

	@Override
	public List<Customers> getAllCustomer() {
		
		return customerRepo.findAll();
	}

	@Override
	public String deleteCustomer(int customerId) {
		customerRepo.deleteById(customerId);
		Customers deletedCustomer = customerRepo.findById(customerId).orElse(null);
		if(deletedCustomer != null) {
			return "customer deletion unsuccesfull";
		}
		return "customer " + customerId +" deleted successfully";
	}
	
	@Override
	public Customers updateCustomer(CustomerDTO customerdto) {
		Customers customer = new Customers();
		customer.setCustomerId(customerdto.getCustomerId());
		customer.setFirstName(customerdto.getFirstName());
		customer.setLastName(customerdto.getLastName());
		customer.setEmailAddress(customerdto.getEmailAddress());
		customer.setUsername(customerdto.getUsername());
		customer.setPassword(customerdto.getPassword());
		customer.setPhoneNumber(customerdto.getPhoneNumber());
		return customerRepo.save(customer);
	}

	@Override
	public Cars addCar(CarDTO cardto) {
		
		Cars car = new Cars();
		car.setCarId(cardto.getCarId());
		car.setMake(cardto.getMake());
		car.setModel(cardto.getModel());
		car.setLocation(cardto.getLocation());
		car.setCarStatus(cardto.getCarStatus());
		car.setSpecification(cardto.getSpecifications());
		car.setPassengerCapacity(cardto.getPassengerCapacity());
		car.setDailyRate(cardto.getDailyRate());
		return carRepo.save(car);
	}

	@Override
	public CarDTO getCarById(int carId) {
		Cars car = carRepo.findById(carId).orElse(null);
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
	public List<Cars> getAllCars() {
		
		return carRepo.findAll();
	}

	@Override
	public String deleteCar(int carId) {
		carRepo.deleteById(carId);
		Cars deletedCar = carRepo.findById(carId).orElse(null);
		if(deletedCar != null) {
			return "car deletion unsuccesfull";
		}
		return "car " + carId +" deleted successfully";
	}
	

	@Override
	public Cars updateCar(CarDTO cardto) {
		Cars car = new Cars();
		car.setCarId(cardto.getCarId());
		car.setMake(cardto.getMake());
		car.setModel(car.getModel());
		car.setLocation(car.getLocation());
		car.setCarStatus(cardto.getCarStatus());
		car.setSpecification(cardto.getSpecifications());
		car.setPassengerCapacity(cardto.getPassengerCapacity());
		car.setDailyRate(cardto.getDailyRate());
		return carRepo.save(car);
	}

	@Override
	public List<Reservations> viewAllReservations() {
		return reservationRepo.findAll();
		
	}

	@Override
	public List<Payments> viewAllPayments() {
		return paymentRepo.findAll();
	}

	@Override
	public Cars discountOnCarPrice(int carId, double discountPrice) throws CarNotFoundException {
       
        carRepo.discountOnCarPrice(carId, discountPrice);

  
        Cars updatedCar = carRepo.findById(carId).orElse(null);
        
        return updatedCar;

	}

	@Override
	public Cars updateCarPrice(int carId , double newPrice) throws CarNotFoundException {
	     Cars car = new Cars();
			Cars existingCar = carRepo.findById(carId).orElse(null);
	        if (existingCar != null) {      
	           existingCar.setDailyRate(newPrice);
	           car = carRepo.save(existingCar);
	        } 
	        else {
	              throw new CarNotFoundException();
		}
	         return car;
		
	}

	@Override
	public String giveFeedback(String adminFeedback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agent addAgent(AgentDTO agentdto) {
		Agent agent = new Agent();
		agent.setAgentId(agentdto.getAgentId());
		agent.setUsername(agentdto.getUsername());
		agent.setPassword(agentdto.getPassword());
		return agentRepo.save(agent);
	}

	@Override
	public AgentDTO getAgentById(int agentId) {
		Agent agent = agentRepo.findById(agentId).orElse(null);
		AgentDTO  agentdto=new AgentDTO();
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
		Agent deletedAgent  = agentRepo.findById(agentId).orElse(null);
		if(deletedAgent != null) {
			return "Agent deletion unsuccesfull";
		}
		return "Agent " + agentId +" deleted successfully";
	}

	@Override
	public List<Payments> getPaymentDetailsForCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservations> getReservationDetailsForCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String revenueReportBetweenDates(LocalDate startDtae , LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String revenueReportGeneratedByCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String totalRevenueReport() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
