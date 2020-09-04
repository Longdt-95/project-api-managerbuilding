package com.laptrinhjavaweb.repository.JDBC.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.laptrinhjavaweb.enity.UserEntity;
import com.laptrinhjavaweb.repository.JDBC.UserRepository;

public class UserRepositoryIMPL extends SimpleJpaRepositoryIMPL<UserEntity> implements UserRepository{


	@Override
	public List<UserEntity> getUsersAssignmentBuildingByBuildingID(long id) {
		String sql = "SELECT * FROM user u JOIN assignmentbuilding a on u.id = a.staffid JOIN user_role ur on u.id = ur.userid WHERE buildingid = "+ id +" and ur.roleid = 2 ";
		return this.findAll(sql);
	}

	@Override
	public List<UserEntity> findAllUser() {
		String sql = "SELECT * FROM user u JOIN user_role ur on u.id = ur.userid JOIN role r on ur WHERE ur.roleid = 2 ";
		return this.findAll(sql);
	}

	@Override
	public boolean isAssignmentBuilding(long staffId, long buildingId) {
		String sql = "SELECT * FROM assignmentbuilding WHERE staffd = ? and buildingid = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, staffId);
			statement.setLong(2, buildingId);
			return statement.execute();
		} catch (SQLException  e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
			return false;
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
