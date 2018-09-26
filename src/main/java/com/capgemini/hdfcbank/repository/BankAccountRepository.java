package com.capgemini.hdfcbank.repository;

public interface BankAccountRepository {

	public double getBalance(long accountId);

	public double updateBalance(long accountId, double balance);
}
