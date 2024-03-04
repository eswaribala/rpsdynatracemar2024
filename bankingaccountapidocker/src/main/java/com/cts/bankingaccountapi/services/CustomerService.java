package com.cts.bankingaccountapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bankingaccountapi.models.Customer;
import com.cts.bankingaccountapi.repositories.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private EntityManager entityManager;
	
	public Customer addCustomer(Customer customer) {
		
		if(customer.getContactNo()>0) {
			return this.customerRepository.save(customer);
		}
		else {
			return null;
		}
	}
	
	
	public List<Customer> getCustomers(){
		return this.customerRepository.findAll();
	}
	
	
	public Customer getCustomerByAccountNo(long accountNo) {
		return this.customerRepository.findById(accountNo).orElse(null);
	}

	//search by contact no (non primary key)
	
	public List<Customer> getCustomersByContactNo(long contactNo){
		
		CriteriaBuilder cb= entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> cq= cb.createQuery(Customer.class);
		Root<Customer> root= cq.from(Customer.class);
		cq.where(cb.equal(root.get("contactNo"), contactNo));
		CriteriaQuery<Customer> result=cq.select(root);
		TypedQuery<Customer> typedQuery= entityManager.createQuery(result);
		return typedQuery.getResultList();
		
	}
	
}
