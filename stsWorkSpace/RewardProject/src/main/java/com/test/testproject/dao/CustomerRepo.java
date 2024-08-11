package com.test.testproject.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.testproject.model.CustomerTransactions;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerTransactions, Integer>{

	//@Query("SELECT c FROM  CustomerTransactions WHERE c.date BETWEEN :startDate AND :endDate AND c.customerId= :customerID" )
	List<CustomerTransactions> findByCustomerIdAndDateBetween(String customerId, LocalDate startDate, LocalDate endDate);
	

}
