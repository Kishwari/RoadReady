/*package com.hexaware.roadready.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.entities.Admin;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.repository.AdminRepository;
import com.hexaware.roadready.repository.AgentRepository;
import com.hexaware.roadready.repository.CustomerRepository;

@Service
public class UserService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AgentRepository agentRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String addCustomer(Customers customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
        return "Customer added to system";
    }

    public String addAgent(Agent agent) {
        agent.setPassword(passwordEncoder.encode(agent.getPassword()));
        agentRepository.save(agent);
        return "Agent added to system";
    }

    public String addAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
        return "Admin added to system";
    }
}*/
