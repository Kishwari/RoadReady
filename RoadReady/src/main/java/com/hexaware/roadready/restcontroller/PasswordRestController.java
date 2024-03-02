package com.hexaware.roadready.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.PasswordDTO;
import com.hexaware.roadready.service.IPasswordService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/roadready/password")
public class PasswordRestController {

	@Autowired
    private IPasswordService passwordUpdateService;

    @PostMapping("/update")
    public ResponseEntity<String> updatePassword(@RequestBody PasswordDTO passwordDTO) {
        String response = passwordUpdateService.updatePassword(passwordDTO);
        return ResponseEntity.ok(response);
    }
    
}
