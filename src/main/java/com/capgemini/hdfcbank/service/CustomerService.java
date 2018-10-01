package com.capgemini.hdfcbank.service;

import com.capgemini.hdfcbank.entities.Customer;
import com.capgemini.hdfcbank.exceptions.LowBalanceException;
import com.capgemini.hdfcbank.exceptions.PasswordChangeFailedException;
import com.capgemini.hdfcbank.exceptions.UpdationFailedException;
import com.capgemini.hdfcbank.exceptions.UserNotFoundException;

public interface CustomerService {
	
	public Customer updateAccount(Customer customer) throws UpdationFailedException;
	public Customer addCustomer(Customer customer);
	public boolean deleteCustomer(long customerId);
	public boolean changePassword(Customer customer, String oldPassword, String newPassword) throws PasswordChangeFailedException;
	public Customer authenticateCustomer(Customer customer) throws UserNotFoundException;

}
