package com.capgemini.hdfcbank.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.hdfcbank.exceptions.LowBalanceException;
import com.capgemini.hdfcbank.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	/*
	 * @Bean public DataSource getDataSource() { DriverManagerDataSource dataSource
	 * = new DriverManagerDataSource();
	 * dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	 * dataSource.setUrl("jdbc:mysql://10.246.92.175:3306/idbibankapp");
	 * dataSource.setUsername("root"); dataSource.setPassword("password"); return
	 * dataSource; }
	 * 
	 * @Bean public JdbcTemplate getJdbcTemplet() { JdbcTemplate template = new
	 * JdbcTemplate(getDataSource()); return template; }
	 */

	@Autowired
	private JdbcTemplate templet;
//	private DataSource dataSource;

	@Override
	public double getBalance(long accountId){
		double balance = templet.queryForObject("SELECT balance from bankaccounts where account_id=?",
				new Object[] { accountId }, Double.class);
		// System.out.println(data);
		return balance;
	}

	@Override
	public double updateBalance(long accountId, double balance) throws LowBalanceException {
		try {
			int result = templet.update("UPDATE bankaccounts set balance=? where account_id=?",
					new Object[] { balance, accountId });
			System.out.println(result);
			if (result == 1) {
				return getBalance(accountId);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return 0;
		}

		throw new LowBalanceException("No account found");
	}

}
