package com.capgemini.hdfcbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hdfcbank.entities.Customer;
import com.capgemini.hdfcbank.repository.CustomerRepository;
import com.capgemini.hdfcbank.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer updateAccount(Customer customer) {

		return customerRepository.updateAccount(customer);
	}

	@Override
	public Customer addCustomer(Customer customer) {

		return customerRepository.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(long customerId) {
		
		return customerRepository.deleteCustomer(customerId);
	}

	@Override
	public boolean changePassword(Customer customer, String oldPassword, String newPassword) {
		
		return customerRepository.changePassword(customer, oldPassword, newPassword);
	}

	@Override
	public Customer authenticateCustomer(Customer customer) {
		
		return customerRepository.authenticateCustomer(customer);
	}

}
