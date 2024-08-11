package com.test.testproject.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
@Entity
public class CustomerTransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String customerId;
    private long amount;
    private LocalDate date;

    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public long getAmount() {
		return amount;
	}


	public void setAmount(long amount) {
		this.amount = amount;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	
	public CustomerTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerTransactions(String customerId, long amount, LocalDate date) {
		super();
	
		this.customerId = customerId;
		this.amount = amount;
		this.date = date;
	}

    
	
	
	
}
