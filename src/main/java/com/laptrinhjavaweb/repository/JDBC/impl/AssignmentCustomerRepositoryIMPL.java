package com.laptrinhjavaweb.repository.JDBC.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.enity.AssignmentCustomerEntity;
import com.laptrinhjavaweb.repository.JDBC.AssignmentCustomerRepository;

public class AssignmentCustomerRepositoryIMPL extends SimpleJpaRepositoryIMPL<AssignmentCustomerEntity> implements AssignmentCustomerRepository{

	@Override
	public List<Long> getStaffIds(long customerId) {
		String sql = "SELECT * FROM assignmentcustomer WHERE customerid = " + customerId;
		List<AssignmentCustomerEntity> entities = findAll(sql);
		List<Long> staffIds = new ArrayList<>();
		for (AssignmentCustomerEntity entity: entities) {
			staffIds.add(entity.getStaffId());
		}
		return staffIds;
	}

	@Override
	public boolean assignCustomer(List<Long> isCheckedUsers, List<Long> unCheckedUsers, long customerId) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			String sqlDelete = "DELETE FROM assignmentcustomer WHERE customerid = ? AND staffid = ?";
			statement = connection.prepareStatement(sqlDelete);
			for (Long long1 : unCheckedUsers) {
				statement.setLong(1, customerId);
				statement.setLong(2, long1);
				statement.execute();
			}
			String sqlInsert = "INSERT INTO assignmentcustomer(customerid,staffid) values (?,?)";
			statement = connection.prepareStatement(sqlInsert);
			for (Long longuser : isCheckedUsers) {
				statement.setLong(1, customerId);
				statement.setLong(2, longuser);
				statement.execute();
			}
			connection.commit();
			flag = true;
			return flag;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
			return flag;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}
	}

}
