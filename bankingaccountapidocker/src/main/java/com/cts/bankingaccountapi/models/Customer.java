package com.cts.bankingaccountapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Customer")
@Inheritance(strategy = InheritanceType.JOINED)
public  class Customer{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Account_No")
	protected long accountNo;
	@Embedded
	protected FullName name;
	@Column(name="Email",nullable = false,length = 150)
	protected String email;
	@Column(name="Contact_No")
	protected long contactNo;
	@Column(name="Password",nullable = false,length = 10)
	protected String password;	

}
