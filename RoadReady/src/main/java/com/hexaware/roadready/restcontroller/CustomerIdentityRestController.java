package com.hexaware.roadready.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hexaware.roadready.entities.CustomerIdentity;
import com.hexaware.roadready.entities.Customers;
import com.hexaware.roadready.exceptions.CustomerNotFoundException;
import com.hexaware.roadready.repository.CustomerIdentityRepository;
import com.hexaware.roadready.repository.CustomerRepository;

import jakarta.transaction.Transactional;



@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/roadready/customerIdentity")
public class CustomerIdentityRestController {

	@Autowired
    CustomerIdentityRepository customerIdentityRepo;
	
	@Autowired
	CustomerRepository customerRepo;

    @PostMapping("/uploadCustomerIdentity/{customerId}")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public String uploadPdfFile(@RequestParam("file") MultipartFile file , @PathVariable int customerId) {
        try {
            CustomerIdentity pdfFile = new CustomerIdentity();
            Customers customer= customerRepo.findById(customerId).orElse(null);
           if(customer!=null) { 
            pdfFile.setCustomerId(customerId);
            pdfFile.setContent(file.getBytes());
            customerIdentityRepo.save(pdfFile);
            return "File uploaded successfully!";
           
        }
           else {
           	throw new CustomerNotFoundException("customer with id" + customerId +"not found");        }
       }
           
            catch (Exception e) {
            return "Failed to upload file: " + e.getMessage();
        }
     }
       
    
    
    
    @GetMapping(value = "/getCustomerIdentity/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_AGENT')")
    public ResponseEntity<byte[]> getPdf(@PathVariable Long id) {
        Optional<CustomerIdentity> optionalPdf = customerIdentityRepo.findById(id);
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
    
    @Transactional
    @DeleteMapping("/deleteCustomerIdentity/{customerId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CUSTOMER')")
    public String deleteCustomerIdentity(@PathVariable int customerId) {
   
    	customerIdentityRepo.deleteByCustomerId(customerId);
    	Customers customer= customerRepo.findById(customerId).orElse(null);	
    if(customer!=null) {
    	return "file deleted successfully";
    }
    else {
    	return "file deletion unsuccessfull";
    }
    }
}
