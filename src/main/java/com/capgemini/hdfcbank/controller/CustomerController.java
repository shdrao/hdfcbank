package com.capgemini.hdfcbank.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.hdfcbank.entities.BankAccount;
import com.capgemini.hdfcbank.entities.Customer;
import com.capgemini.hdfcbank.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public String checking() {
//		customerService.addCustomer(new Customer("A", 3, "a@a.in", "xyz", "123", LocalDate.now()
//				, new BankAccount("Savings",10,9999)));
		return "index";
	}

}
