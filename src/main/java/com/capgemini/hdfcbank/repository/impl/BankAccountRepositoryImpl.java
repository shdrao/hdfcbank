package com.capgemini.hdfcbank.repository.impl;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.capgemini.hdfcbank.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://10.246.92.175:3306/idbibankapp");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		return dataSource;
	}
	
	
	@Bean
	public JdbcTemplate getJdbcTemplet() {
		JdbcTemplate template = new JdbcTemplate(getDataSource());
		return template;
	}
	@Autowired
	private JdbcTemplate templet;
  
	@Override
	public double getBalance(long accountId) {
		double data = templet.queryForObject("SELECT balance from bankaccounts where account_id=?", new Object[] {accountId}, Double.class);
		System.out.println(data);
		return 0;
	}

	@Override
	public double updateBalance(long accountId, double balance) {
		// TODO Auto-generated method stub
		return 0;
	}

}
