package com.capgemini.hdfcbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.hdfcbank.entities.Customer;
import com.capgemini.hdfcbank.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	
	
	@RequestMapping("/login")
	public String checking(Model model, HttpServletRequest request, HttpSession session, @RequestParam long custId,
			@RequestParam String password) {
		Customer customer = new Customer(null, custId, null, null,
				password, null, null);

		customer = customerService.authenticateCustomer(customer);

		if (customer.getEmailId() != null) {
			model.addAttribute("customer", customer);
			session.setAttribute("customer", customer);
			return "accountDetails";
		}
		return "index";
	}

}
