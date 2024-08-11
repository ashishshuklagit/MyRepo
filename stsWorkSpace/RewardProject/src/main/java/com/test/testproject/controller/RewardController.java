package com.test.testproject.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.testproject.dao.CustomerRepo;
import com.test.testproject.model.CustomerTransactions;
import com.test.testproject.service.RewardService;

@RestController
public class RewardController {
	
	@Autowired 
	CustomerRepo repo;
	
	@Autowired
	RewardService rewardService;
	
	@GetMapping("/hello")
	public void test(){
		System.out.println("Hi");
	}
	
	
	  @PostMapping("addData") 
	  public String insertThreeMonthAmountInDB(){ 
		  repo.save(new CustomerTransactions("cust1", 120, LocalDate.of(2024, 5, 15)));
		  repo.save(new CustomerTransactions("cust1", 75, LocalDate.of(2024, 6, 10)));
		  repo.save(new CustomerTransactions("cust2", 200, LocalDate.of(2024, 5, 20)));
		  repo.save(new CustomerTransactions("cust2", 500, LocalDate.of(2024, 7, 5)));
		  return "data saved in db"; 
		  
	  }
	  
	  @GetMapping("getMonthaly/{customerId}") 
	  public Map<String, Integer>  calculateMonthalyRewards(@PathVariable String customerId, @RequestParam String startDate, @RequestParam String endDate ){
	  
		    LocalDate start = LocalDate.parse(startDate);
	        LocalDate end = LocalDate.parse(endDate);
		  return rewardService.getMonthalyRewards(customerId,start,end);
	  
	  }
	  
	 @GetMapping("getTotal/{customerId}")
	 public int calculateTotalPoints(@PathVariable String customerId, @RequestParam String startDate, @RequestParam String endDate) {
		     LocalDate start = LocalDate.parse(startDate);
	         LocalDate end = LocalDate.parse(endDate);
		     return rewardService.calculateTotalPoints(customerId, start, end);
	 }

}
	 

