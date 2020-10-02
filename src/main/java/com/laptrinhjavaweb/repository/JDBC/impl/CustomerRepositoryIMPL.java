package com.laptrinhjavaweb.repository.JDBC.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.enity.CustomerEntity;
import com.laptrinhjavaweb.repository.JDBC.CustomerRepository;

public class CustomerRepositoryIMPL extends SimpleJpaRepositoryIMPL<CustomerEntity> implements CustomerRepository {

	@Override
	public List<CustomerEntity> getAll(long userId, String code) {
		if (code.equals("manager")) {
			return findAll();
		} else if (code.equals("staff")) {
			String sql = "SELECT * FROM customer c JOIN assignmentcustomer a ON c.id = a.customerid WHERE staffid = "
					+ userId;
			return findAll(sql);
		}
		return null;
	}

	@Override
	public List<CustomerEntity> getCustomersSearch(CustomerSearchBuilder customerSearchBuilder) {
		StringBuilder sql = new StringBuilder("SELECT * FROM customer c");
		if (customerSearchBuilder.getStaffId() != null && !customerSearchBuilder.getStaffId().equals("")) {
			sql.append(" JOIN assignmentcustomer a ON c.id = a.customerid");
		}
		sql.append(" WHERE 1 =1");
		if (customerSearchBuilder.getStaffId() != null && !customerSearchBuilder.getStaffId().equals("")) {
			sql.append(" AND a.staffid = " + customerSearchBuilder.getStaffId());
		}
		sql = buildSqlSearchCustomerCommon(customerSearchBuilder, sql);
		return findAll(sql.toString());
	}

	private StringBuilder buildSqlSearchCustomerCommon(CustomerSearchBuilder customerSearchBuilder, StringBuilder sql) {
		Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				if (!field.getName().equals("staffId")) {
					if (field.getType().getName().equals("java.lang.String")) {
						if (field.get(customerSearchBuilder) != null && !field.get(customerSearchBuilder).equals("")) {
							sql.append(" AND c." + field.getName().toLowerCase() + " like '%"
									+ field.get(customerSearchBuilder) + "%'");
						}
					} 
				}
			}
			return sql;
		} catch (IllegalArgumentException | IllegalAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public long saveCustomer(CustomerEntity customerEntity) {
		return save(customerEntity);
	}

	@Override
	public boolean updateCustomer(CustomerEntity customerEntity) {
		return update(customerEntity);
	}

	@SuppressWarnings("resource")
	@Override
	public boolean delWithTransaction(long longId) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			String sqlDelFromAssignment = "DELETE FROM assignmentcustomer WHERE customerid = ?";
			statement = connection.prepareStatement(sqlDelFromAssignment);
			statement.setLong(1, longId);
			statement.execute();
			String sqlDelFromTransaction = "DELETE FROM transaction WHERE customerid = ?";
			statement = connection.prepareStatement(sqlDelFromTransaction);
			statement.setLong(1, longId);
			statement.execute();
			String sqlDelCustomer = "DELETE FROM customer WHERE id = ?";
			statement = connection.prepareStatement(sqlDelCustomer);
			statement.setLong(1, longId);
			statement.execute();
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
				return flag;
			}
		}
	}
	
}
