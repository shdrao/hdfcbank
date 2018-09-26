package com.capgemini.hdfcbank.entities;

public class BankAccount {
	
	private String accountType;
	private double balance;
	private long accountId;
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(String accountType, double balance, long accountId) {
		super();
		this.accountType = accountType;
		this.balance = balance;
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "BankAccount [accountType=" + accountType + ", balance=" + balance + ", accountId=" + accountId + "]";
	}
	


}
