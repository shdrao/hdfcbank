package com.capgemini.hdfcbank.repository;

import org.springframework.dao.DataAccessException;

import com.capgemini.hdfcbank.entities.Customer;
import com.capgemini.hdfcbank.exceptions.LowBalanceException;

public interface CustomerRepository {

	public Customer updateAccount(Customer customer) throws DataAccessException;
	public Customer addCustomer(Customer customer);
	public boolean deleteCustomer(long customerId);
	public boolean changePassword(Customer customer, String oldPassword, String newPassword) throws DataAccessException;
	public Customer authenticateCustomer(Customer customer) throws DataAccessException;
	
}
