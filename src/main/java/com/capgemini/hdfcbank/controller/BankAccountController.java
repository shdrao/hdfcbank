package com.capgemini.hdfcbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.hdfcbank.repository.BankAccountRepository;

@Controller
public class BankAccountController {


	@Autowired
	private BankAccountRepository bankAccountRepository;
	

	@RequestMapping("/")
	public String sayHello() {
		bankAccountRepository.getBalance(221700);
		System.out.println("jsdakldjaksjdklasjdklj");
		return "index";
	}
	
	
}
