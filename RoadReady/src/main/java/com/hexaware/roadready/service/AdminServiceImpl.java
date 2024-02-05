package com.hexaware.roadready.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.AgentDTO;
import com.hexaware.roadready.dto.CarDTO;
import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Cars;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Reservations;

@Service
public class AdminServiceImpl implements IAdminService {

	@Override
	public CustomerDTO addCustomer(CustomerDTO customer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public CustomerDTO updateCustomer(CustomerDTO customer) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public CustomerDTO getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customers> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarDTO addCar(CarDTO car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarDTO getCarById(int carId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cars> getAllCars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCar(int carId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarDTO updateCar(CarDTO car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservations> viewAllReservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payments> viewAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarDTO discountOnCarPrice(int carId, double discountPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarDTO updateCarPrice(int carId , double newPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String giveFeedback(String adminFeedback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgentDTO addAgent(AgentDTO agent) {
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
