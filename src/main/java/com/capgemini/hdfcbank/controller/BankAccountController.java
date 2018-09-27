package com.capgemini.hdfcbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.hdfcbank.entities.BankAccount;
import com.capgemini.hdfcbank.entities.Customer;
import com.capgemini.hdfcbank.exceptions.LowBalanceException;
import com.capgemini.hdfcbank.repository.BankAccountRepository;
import com.capgemini.hdfcbank.service.BankAccountService;

@Controller
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;

	@RequestMapping("/fundtransferPage")
	public String getfundTransferPage(HttpSession session, HttpServletRequest request, Model model) {
		session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		model.addAttribute("account", customer.getAccount());
		return "fundTransfer";
	}
	
	
	@RequestMapping("/fundTransfer")
	public String transferFund(@RequestParam long fromAcc, @RequestParam long toAcc, @RequestParam long amount) {
		bankAccountService.fundTransfer(fromAcc, toAcc, amount);
		return "success";
	}

}
