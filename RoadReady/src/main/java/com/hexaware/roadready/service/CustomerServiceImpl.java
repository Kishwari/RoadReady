package com.hexaware.roadready.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.CustomerDTO;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
    
	@Autowired
	CustomerRepository customerRepo;
	
	
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

	
	
	
	
}