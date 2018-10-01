package com.capgemini.hdfcbank.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.hdfcbank.entities.Customer;
import com.capgemini.hdfcbank.exceptions.UserNotFoundException;
import com.capgemini.hdfcbank.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/login")
	public String checking(Model model, HttpServletRequest request, HttpSession session, @RequestParam long custId,
			@RequestParam String password) {
		Customer customer = new Customer(null, custId, null, null, password, null, null);

		customer = customerService.authenticateCustomer(customer);

		if (customer.getEmailId() != null) {
			model.addAttribute("customer", customer);
			session.setAttribute("customer", customer);
			return "accountDetails";
		}
		return "index";

	}

	@RequestMapping(value = "/account")
	public String viewAccount(Model model, HttpSession session) {
		return "accountDetails";
	}

	@RequestMapping(value = "/editCustomer")
	public String editProfilePage(HttpSession session, Model model, HttpServletRequest request) {
		session = request.getSession();
		Customer c = (Customer) session.getAttribute("customer");
		model.addAttribute("customer", c);
		return "editCustomer";
	}

	@RequestMapping(value = "/editprofile2", method = RequestMethod.POST)
	public String editProfiley(Model model, @RequestParam String custName, @RequestParam String custAddress,
			@RequestParam String custEmail, @RequestParam String custDOB, HttpSession session) {

		Customer customer = (Customer) session.getAttribute("customer");

		customer.setAddress(custAddress);
		customer.setCustomerName(custName);
		customer.setEmailId(custEmail);
		customer.setDateOfBirth(LocalDate.parse(custDOB));

		customerService.updateAccount(customer);

		session.setAttribute("customer", customer);
		return "forward:/editCustomer";

	}

	@RequestMapping(value = "/editprofile", method = RequestMethod.POST)
	public String editProfile(Model model, @ModelAttribute Customer customer, HttpSession session) {
//		Customer customer = (Customer) session.getAttribute("customer");
//		customer.setAddress(custAddress);
//		customer.setCustomerName(custName);
//		customer.setEmailId(custEmail);
//		customer.setDateOfBirth(LocalDate.parse(custDOB));
		customerService.updateAccount(customer);
		session.setAttribute("customer", customer);
		return "forward:/editCustomer";
	}

	@RequestMapping(value = "/editPasswordPage")
	public String editPasswordPage() {
		return "changePassword";
	}

	@RequestMapping(value = "/changePassword")
	public String editPassword(HttpSession session, @RequestParam String oldPassword, @RequestParam String newPassword,
			HttpServletRequest request) {
		Customer customer = (Customer) session.getAttribute("customer");
		if (customerService.changePassword(customer, oldPassword, newPassword)) {
			session.setAttribute("customer", customer);
			request.setAttribute("success", true);
		} else {
			request.setAttribute("success", false);
		}
		return "success";

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		request.setAttribute("logout", true);
		return "index";
	}

}
