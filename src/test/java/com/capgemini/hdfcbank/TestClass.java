package com.capgemini.hdfcbank;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.hdfcbank.controller.CustomerController;
import com.capgemini.hdfcbank.entities.BankAccount;
import com.capgemini.hdfcbank.entities.Customer;
import com.capgemini.hdfcbank.repository.CustomerRepository;
import com.capgemini.hdfcbank.service.CustomerService;

public class TestClass {

	@InjectMocks
	CustomerController customerController;

	@Mock
	CustomerService customerService;
	MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public void testAuthenticate() throws Exception {
		Customer customer = new Customer();
		customer.setCustomerId(12345);
		customer.setPassword("12");

		Customer customer1 = new Customer("A", 12345, "b@b", "xyz", "12", LocalDate.now(), new BankAccount());
		Customer customer2 = new Customer(null, 12345, null, null, "12", null, null);

		when(customerService.authenticateCustomer(customer)).thenReturn(customer1);
		mockMvc.perform(get("/login").flashAttr("customer", customer)).andExpect(view().name("accountDetails"));

		when(customerService.authenticateCustomer(customer2)).thenReturn(customer2);
		mockMvc.perform(get("/login").flashAttr("customer", customer2)).andExpect(view().name("index"));
	}

	@Test
	public void testLogout() throws Exception {
		mockMvc.perform(post("/logout")).andExpect(view().name("redirect:/"));
	}
	
	@Test
	public void testEditCustomer() {
	Customer customer1 = new Customer("A", 12345, "b@b", "xyz", "12", LocalDate.now(), new BankAccount());
	Customer customer2 = new Customer("A", 12345, "b@b", "pqr", "12", LocalDate.now(), new BankAccount());
	
	
	}

}
