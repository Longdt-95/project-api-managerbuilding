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
	public List<UserEntity> findAllStaff(String role) {
		String sql = "SELECT * FROM user u JOIN user_role ur on u.id = ur.userid JOIN role r on ur.roleid = r.id WHERE r.code = '" + role + "'";
		return this.findAll(sql);
	}

	@Override
	public boolean isAssignmentBuilding(long staffId, long buildingId) {
		String sql = "SELECT * FROM assignmentbuilding WHERE staffid = ? and buildingid = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean flag = false;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, staffId);
			statement.setLong(2, buildingId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				flag = true;
			}
			return flag;
		} catch (SQLException  e) {
				e.printStackTrace();
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
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
