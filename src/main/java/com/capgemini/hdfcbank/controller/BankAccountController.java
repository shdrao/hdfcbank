package com.capgemini.hdfcbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.hdfcbank.exceptions.LowBalanceException;
import com.capgemini.hdfcbank.repository.BankAccountRepository;
import com.capgemini.hdfcbank.service.BankAccountService;

@Controller
public class BankAccountController {


	@Autowired
	private BankAccountService bankAccountService;
	
	

	@RequestMapping("/")
	public String sayHello() {
		
		System.out.println("Balance"+bankAccountService.getBalance(221700));

		try {
			System.out.println("withdraw"+bankAccountService.withdraw(221700, 100));
			System.out.println("deposit"+bankAccountService.deposit(221700, 500));
		} catch (LowBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return "index";
	}
	
	
}
