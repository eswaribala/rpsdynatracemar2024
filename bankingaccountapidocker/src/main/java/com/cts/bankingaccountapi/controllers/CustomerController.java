package com.cts.bankingaccountapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bankingaccountapi.dtos.ResponseWrapper;
import com.cts.bankingaccountapi.models.Customer;
import com.cts.bankingaccountapi.services.CustomerService;


@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;	
	@PostMapping("/v1.0/")
	@CrossOrigin(allowedHeaders = "*",origins = "*", methods=RequestMethod.POST)
	public ResponseEntity<ResponseWrapper> addCustomer(@RequestBody Customer customer){
		
		Customer customerObj=this.customerService.addCustomer(customer);
		if(customer!=null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseWrapper<Customer>(customerObj));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					new ResponseWrapper("Customer Could not be added"));
		}
		
	}
	@GetMapping("/v1.0/")
	@CrossOrigin(allowedHeaders = "*",origins = "*", methods=RequestMethod.GET)
	public List<Customer> getAllCustomers(){
		return this.customerService.getCustomers();
	}
	
	@GetMapping(value="/v1.0/accounts/{accountNo}",
			produces = { "application/json"})
	@CrossOrigin(allowedHeaders = "*",origins = "*", methods=RequestMethod.GET)
	public Customer getCustomerByAccountNo(@PathVariable("accountNo") 
	long accountNo){
	  return this.customerService.getCustomerByAccountNo(accountNo);	  
	
	}
	
	@GetMapping("/v1.0/{contactNo}")
	@CrossOrigin(allowedHeaders = "*",origins = "*", methods=RequestMethod.GET)
	public List<Customer> getAllCustomersByContactNo(@PathVariable("contactNo") 
	long contactNo){
		return this.customerService.getCustomersByContactNo(contactNo);
	
	}
}
