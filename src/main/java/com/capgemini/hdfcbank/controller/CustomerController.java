package com.capgemini.hdfcbank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.hdfcbank.entities.Customer;
import com.capgemini.hdfcbank.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/")
	public String checking(Model model, HttpServletRequest request) {
		Customer customer = new Customer(null, Long.parseLong(request.getParameter("custId")), null, null,
				request.getParameter("password"), null, null);

		customerService.authenticateCustomer(customer);
		if (customer.getEmailId() != null)
			return "index";
		return "index";
	}

}
