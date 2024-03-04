package com.cts.bankingaccountapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.bankingaccountapi.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
