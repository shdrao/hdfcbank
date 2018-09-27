package com.capgemini.hdfcbank.service;

public interface BankAccountService {

	public double getBalance(long accountId);

	public double withdraw(long accountId, double balance);

	public double deposit(long accountId, double balance);

	public boolean fundTransfer(long fromAcc, long toAcc, double balance);

}
