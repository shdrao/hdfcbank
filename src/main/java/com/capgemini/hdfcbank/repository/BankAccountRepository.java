package com.capgemini.hdfcbank.repository;

import org.springframework.dao.DataAccessException;

import com.capgemini.hdfcbank.exceptions.LowBalanceException;

public interface BankAccountRepository {

	public double getBalance(long accountId);

	public double updateBalance(long accountId, double balance) throws DataAccessException;
}
