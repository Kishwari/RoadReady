package com.hexaware.roadready.service;

import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.PasswordDTO;


public interface IPasswordService {

	 public String updatePassword(PasswordDTO passwordDTO);
}
