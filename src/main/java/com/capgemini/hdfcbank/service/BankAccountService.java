package com.capgemini.hdfcbank.service;

import com.capgemini.hdfcbank.exceptions.LowBalanceException;

public interface BankAccountService {

	public double getBalance(long accountId);

	public double withdraw(long accountId, double balance) throws LowBalanceException;

	public double deposit(long accountId, double balance) throws LowBalanceException;

	public boolean fundTransfer(long fromAcc, long toAcc, double balance);

}
