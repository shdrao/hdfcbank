package com.capgemini.hdfcbank;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.hdfcbank.controller.CustomerController;
import com.capgemini.hdfcbank.entities.BankAccount;
import com.capgemini.hdfcbank.entities.Customer;
import com.capgemini.hdfcbank.repository.CustomerRepository;

public class TestClass {

	@InjectMocks
	CustomerController customerController;

	@Mock
	CustomerRepository customerRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAuthenticate() {
		Customer customer = new Customer();
		customer.setCustomerId(12345);
		customer.setPassword("12");

		Customer customer1 = new Customer("Sharath Rao", 12345, "sharath@hamd.com", "vikroli", "12",
				LocalDate.of(2008, 07, 04), new BankAccount(221700, 808, "SAVINGS"));

		when(customerRepository.authenticateCustomer(customer)).thenReturn(customer1);

		//CustomerController sc= customerController.checking(null, null, null, 0, null);
		
		assertEquals(customer1, customerRepository.authenticateCustomer(customer));

	}

}
