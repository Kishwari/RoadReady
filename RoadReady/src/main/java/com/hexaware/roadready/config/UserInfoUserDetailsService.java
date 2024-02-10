/*package com.hexaware.roadready.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hexaware.roadready.entities.Admin;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.repository.AdminRepository;
import com.hexaware.roadready.repository.AgentRepository;
import com.hexaware.roadready.repository.CustomerRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customers> customer = customerRepository.findByUsername(username);
        if (customer.isPresent()) {
            return new UserInfoUserDetails(customer.get());
        }

        Optional<Agent> agent = agentRepository.findByUsername(username);
        if (agent.isPresent()) {
            return new UserInfoUserDetails(agent.get());
        }

        Optional<Admin> admin = adminRepository.findByUsername(username);
        if (admin.isPresent()) {
            return new UserInfoUserDetails(admin.get());
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}*/
