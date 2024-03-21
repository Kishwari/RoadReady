package com.hexaware.roadready.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.PasswordDTO;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class PasswordServiceImpl implements IPasswordService{

	 @Autowired
	    private ICustomerService customerService;

	    @Autowired
	    private IAdminService adminService;

	    @Autowired
	    private IAgentService agentService;

	    public String updatePassword(PasswordDTO passwordDTO) {
	        String username = passwordDTO.getUsername();
	        String newPassword = passwordDTO.getNewPassword();

	        if (customerService.checkIfCustomerExists(username)) {
	            return customerService.updateCustomerPassword(username, newPassword);
	        } else if (adminService.checkIfAdminExists(username)) {
	            return adminService.updateAdminPassword(username, newPassword);
	        } else if (agentService.checkIfAgentExists(username)) {
	            return agentService.updateAgentPassword(username, newPassword);
	        } else {
	            return "User not found";
	        }
	    }
}
