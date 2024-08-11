package com.test.testproject.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.testproject.dao.CustomerRepo;
import com.test.testproject.model.CustomerTransactions;

@Service
public class RewardService {
	
	@Autowired
	CustomerRepo repo;
	
	public int calculatePoints(double amount) {
		
		int points=0;
		 
		if(amount>100) {
			 points+=(amount-100)*2;
			 points=100;
		 } 
		
		if(amount>50) {
			points+=(amount-50)*1;
		}
		return points;
	}

	public Map<String, Integer> getMonthalyRewards(String customerId, LocalDate startDate, LocalDate endDate) {
		
		List<CustomerTransactions> transactions = repo.findByCustomerIdAndDateBetween(customerId, startDate, endDate);
		Map<String, Integer> monthlyPoints = new HashMap<>();

        for (CustomerTransactions transaction : transactions) {
            String month = transaction.getDate().getMonth().toString();
            int points = calculatePoints(transaction.getAmount());
            
            monthlyPoints.put(month, monthlyPoints.getOrDefault(month, 0) + points);
        }

        return monthlyPoints;
	}



	public int calculateTotalPoints(String customerId, LocalDate startDate, LocalDate endDate) {
        List<CustomerTransactions> transactions = repo.findByCustomerIdAndDateBetween(customerId, startDate, endDate);
        int totalPoints = 0;

        for (CustomerTransactions transaction : transactions) {
            totalPoints += calculatePoints(transaction.getAmount());
        }

        return totalPoints;
    }

}
