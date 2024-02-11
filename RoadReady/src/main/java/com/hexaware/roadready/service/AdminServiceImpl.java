package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.AdminDTO;
import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.entities.Admin;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.repository.AdminRepository;
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
	AdminRepository adminRepo;
	
	@Autowired
	CarRepository carRepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	PaymentRepository paymentRepo;
	
	@Autowired
	AgentRepository agentRepo;
	
	@Autowired
   PasswordEncoder passwordEncoder;
	
/*	@Override
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
	public List<CustomerDTO> getAllCustomer() {
		List<Customers> customersList = customerRepo.findAll();
		List<CustomerDTO> customerDTOList = new ArrayList<>();
		for(Customers customer : customersList) {
			CustomerDTO customerdto = new CustomerDTO();
			customerdto.setCustomerId(customer.getCustomerId());
			customerdto.setFirstName(customer.getFirstName());
			customerdto.setLastName(customer.getLastName());
			customerdto.setEmailAddress(customer.getEmailAddress());
			customerdto.setUsername(customer.getUsername());
			customerdto.setPassword(customer.getPassword());
			customerdto.setPhoneNumber(customer.getPhoneNumber());
			
			customerDTOList.add(customerdto);
		}
		return customerDTOList;
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
	public List<CarDTO> getAllCars() {
		List<Cars> carsList = carRepo.findAll();
		List<CarDTO> carDTOList = new ArrayList<>();
		for(Cars car : carsList) {
			CarDTO cardto=new CarDTO();
			cardto.setCarId(car.getCarId());
			cardto.setMake(car.getMake());
			cardto.setModel(car.getModel());
			cardto.setCarStatus(car.getCarStatus());
			cardto.setSpecifications(car.getSpecification());
			cardto.setLocation(car.getLocation());
			cardto.setPassengerCapacity(car.getPassengerCapacity());
			cardto.setDailyRate(car.getDailyRate());
			
			carDTOList.add(cardto);
		}
		return carDTOList;
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
	public List<ReservationDTO> viewAllReservations() {
		 List<Reservations> reservationList = reservationRepo.findAll();
		    List<ReservationDTO> reservationDTOList = new ArrayList<>();
		    for (Reservations reservation : reservationList) {
		        ReservationDTO reservationDTO = new ReservationDTO();
		        reservationDTO.setReservationId(reservation.getResevationId());
		        reservationDTO.setReservationStatus(reservation.getReservationstatus());
		        reservationDTO.setDateOfReservation(reservation.getDateOfReservation());
		        reservationDTO.setDateOfPickup(reservation.getDateOfPickup());
		        reservationDTO.setDateOfDropoff(reservation.getDateOfDropoff());

		        reservationDTOList.add(reservationDTO);
		    }
		    return reservationDTOList;
		
	}

	@Override
	public List<PaymentDTO> viewAllPayments() {
		 List<Payments> paymentList = paymentRepo.findAll();
		    List<PaymentDTO> paymentDTOList = new ArrayList<>();
		    for (Payments payment : paymentList) {
		        PaymentDTO paymentDTO = new PaymentDTO();
		        paymentDTO.setPaymentId(payment.getPaymentId());
		        paymentDTO.setAmountPaid(payment.getAmountPaid());
		        paymentDTO.setDateOfPayment(payment.getDateOfPayment());
		        paymentDTO.setModeOfPayment(payment.getModeOfPayment());

		        paymentDTOList.add(paymentDTO);
		    }
		    return paymentDTOList;
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
	}   */

	
	@Override
	public String revenueReportBetweenDates(LocalDate startDate , LocalDate endDate) {
		Double amount = paymentRepo.findRevenueBetweenDates(startDate, endDate);
		return "Total revenue Generated Between " + startDate + " and " +endDate+ " is " + amount;
	}

	@Override
	public String revenueReportGeneratedByCustomer(int customerId) {
		Double amount = paymentRepo.findRevenueBycustomerId(customerId);
		return "Total Revenue Generated By Customer " + customerId + " is " +amount;
	}

	@Override
	public String totalRevenueReport() {
		Double amount = paymentRepo.findTotalRevenue();
		
		return "Total Revenue generated till today for RoadReady is " + amount ;
	}

	@Override
	public Admin addAdmin(AdminDTO admindto) {
		Admin admin = new Admin();
		admin.setAdminId(admindto.getAdminId());
		admin.setUsername(admindto.getUsername());
		//admin.setPassword(admindto.getPassword());
		 admin.setPassword(passwordEncoder.encode(admindto.getPassword()));
		 admin.setRole("ROLE_ADMIN");
		return adminRepo.save(admin);
		
	}
	
	
	

	/*@Override
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
	}*/

	
	

	

}
