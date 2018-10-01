package com.capgemini.hdfcbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.hdfcbank.entities.Customer;
import com.capgemini.hdfcbank.exceptions.LowBalanceException;
import com.capgemini.hdfcbank.exceptions.PasswordChangeFailedException;
import com.capgemini.hdfcbank.exceptions.UpdationFailedException;
import com.capgemini.hdfcbank.exceptions.UserNotFoundException;
import com.capgemini.hdfcbank.repository.CustomerRepository;
import com.capgemini.hdfcbank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer updateAccount(Customer customer) throws UpdationFailedException {

		try {
			return customerRepository.updateAccount(customer);
		} catch (DataAccessException e) {
			UpdationFailedException updationFailedException = new UpdationFailedException(
					"failed to update the customer details");
			updationFailedException.initCause(e);
			throw updationFailedException;
		}

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
	public boolean changePassword(Customer customer, String oldPassword, String newPassword)
			throws PasswordChangeFailedException {
		try {
			return customerRepository.changePassword(customer, oldPassword, newPassword);
		} catch (DataAccessException e) {
			PasswordChangeFailedException passwordChangeFailedException = new PasswordChangeFailedException(
					"Failed to change the password");
			passwordChangeFailedException.initCause(e);
			throw e;
		}

	}

	@Override
	public Customer authenticateCustomer(Customer customer) throws UserNotFoundException {

		try {
			return customerRepository.authenticateCustomer(customer);
		} catch (DataAccessException e) {
			UserNotFoundException u = new UserNotFoundException("No user Found");
			u.initCause(e);
			throw u;
		}

	}

}
