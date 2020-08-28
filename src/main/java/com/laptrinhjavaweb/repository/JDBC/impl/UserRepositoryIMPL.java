package com.laptrinhjavaweb.repository.JDBC.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.enity.UserEntity;
import com.laptrinhjavaweb.repository.JDBC.UserRepository;

public class UserRepositoryIMPL extends SimpleJpaRepositoryIMPL<UserEntity> implements UserRepository{

	@Override
	public List<UserEntity> findAllUser() {
		return findAll();
	}

	@Override
	public List<UserEntity> getUsersAssignmentBuildingByBuildingID(long id) {
		String sql = "SELECT * FROM user u LEFT JOIN assignmentbuilding a on u.id = a.staffid where buildingid = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			return objectMapper.maprow(resultSet, UserEntity.class);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
