package com.capgemini.hdfcbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.hdfcbank.exceptions.LowBalanceException;
import com.capgemini.hdfcbank.repository.BankAccountRepository;
import com.capgemini.hdfcbank.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Override
	public double getBalance(long accountId) {
		
		try {
			return bankAccountRepository.getBalance(accountId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public double withdraw(long accountId, double balance) throws LowBalanceException {
		if (getBalance(accountId) >= balance) {
			double newBalance = getBalance(accountId) - balance;
			return bankAccountRepository.updateBalance(accountId, newBalance);
		}
		throw new LowBalanceException("Balance is low to make transaction");
	}

	@Override
	public double deposit(long accountId, double balance) {
		double newBalance = getBalance(accountId) + balance;
		return bankAccountRepository.updateBalance(accountId, newBalance);
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double balance) {
		getBalance(toAcc);

		withdraw(fromAcc, balance);
		deposit(toAcc, balance);
		return true;

	}

}
