package com.cts.bankingaccountapi.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Address_Id")
	private long addressId;
	@Column(name="Door_No",nullable = false,length = 5)
	private String doorNo;
	@Column(name="Street_Name",nullable = false,length = 150)
	private String streetName;
	@Column(name="City",nullable = false,length = 100)
	private String city;
	@Column(name="pinCode")
	private long pincode;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "Account_No"),
            name = "Account_No_FK")
	private Customer customer;

}
