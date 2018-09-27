package com.capgemini.hdfcbank.repository;

import com.capgemini.hdfcbank.exceptions.LowBalanceException;

public interface BankAccountRepository {

	public double getBalance(long accountId);

	public double updateBalance(long accountId, double balance) throws LowBalanceException;
}
