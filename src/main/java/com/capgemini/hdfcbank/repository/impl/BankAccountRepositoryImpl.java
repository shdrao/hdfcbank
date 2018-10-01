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
	public double getBalance(long accountId) throws DataAccessException {
		try {
			double balance = templet.queryForObject("SELECT balance from bankaccounts where account_id=?",
					new Object[] { accountId }, Double.class);
			return balance;
		} catch (DataAccessException e) {
			e.initCause(new EmptyResultDataAccessException("Expected 1 actual 0", 1));
			throw e;
		}
	}

	@Override
	public double updateBalance(long accountId, double balance) throws DataAccessException {
		try {
			templet.update("UPDATE bankaccounts set balance=? where account_id=?", new Object[] { balance, accountId });
			// System.out.println(result);

			return getBalance(accountId);

		} catch (DataAccessException e) {
			e.initCause(new EmptyResultDataAccessException("Expected 1 actual 0", 1));
			throw e;
		}
	}
}
