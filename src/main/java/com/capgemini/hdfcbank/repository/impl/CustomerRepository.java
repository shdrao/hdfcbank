package com.capgemini.hdfcbank.repository.impl;

import com.capgemini.hdfcbank.entities.Customer;

public interface CustomerRepository {

	public Customer updateAccount(Customer customer);
	public Customer addCustomer(Customer customer);
	public boolean deleteCustomer(long customerId);
	public boolean changePassword(Customer customer, String oldPassword, String newPassword);
	public Customer authenticateCustomer(Customer customer);
	
}
