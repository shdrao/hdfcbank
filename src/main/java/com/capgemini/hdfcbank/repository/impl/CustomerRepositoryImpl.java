package com.capgemini.hdfcbank.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capgemini.hdfcbank.entities.Customer;
import com.capgemini.hdfcbank.repository.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
// select * from customers inner join bankaccounts on customers.customer_id=bankaccounts.customer_id where customers.customer_id=12345 and customers.customer_password=12;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Customer updateAccount(Customer customer) {
		int count = jdbcTemplate.update("UPDATE * from customers WHERE customer_id=?",
				new Object[] { customer.getCustomerId() });
		if (count != 0)
			return customer;
		return null;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		int count = jdbcTemplate.update("INSERT into customers VALUES(?,?,?,?,?,?)",
				new Object[] { customer.getCustomerId(), customer.getCustomerName(), customer.getPassword(),
						customer.getEmailId(), customer.getAddress(), customer.getDateOfBirth() });

		if (count != 0)
			return customer;
		return null;
	}

	@Override
	public boolean deleteCustomer(long customerId) {
		int count = jdbcTemplate.update("DELETE from customers WHERE customer_id=? ", new Object[] { customerId });
		if (count != 0)
			return true;
		return false;
	}

	@Override
	public boolean changePassword(Customer customer, String oldPassword, String newPassword) {
		if (customer.getPassword().equals(oldPassword)) {
			int count = jdbcTemplate.update("UPDATE customers SET password=? WHERE customer_id=?",
					new Object[] { newPassword, customer.getCustomerId() });
			if (count != 0)
				return true;
		}
		return false;
	}

	@Override
	public Customer authenticateCustomer(Customer customer) {
		return jdbcTemplate.queryForObject("SELECT * from customers WHERE customer_id=?" + " and customer_password=?",
				new Object[] { customer.getCustomerId(), customer.getPassword() }, new CustomerRowMapper());
	}

	private class CustomerRowMapper implements RowMapper<Customer> {

		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt(1));
			customer.setCustomerName(rs.getString(2));
			customer.setPassword(rs.getString(3));
			customer.setEmailId(rs.getString(4));
			customer.setAddress(rs.getString(5));
			customer.setDateOfBirth(rs.getDate(6).toLocalDate());
			return customer;
		}
	}
}
