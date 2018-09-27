package com.capgemini.hdfcbank.service;

import com.capgemini.hdfcbank.entities.Customer;

public interface CustomerService {
	
	public Customer updateAccount(Customer customer);
	public Customer addCustomer(Customer customer);
	public boolean deleteCustomer(long customerId);
	public boolean changePassword(Customer customer, String oldPassword, String newPassword);
	public Customer authenticateCustomer(Customer customer);

}
