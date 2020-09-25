package com.laptrinhjavaweb.repository.JDBC.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.enity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.JDBC.AssignmentBuildingRepository;

public class AssignmentBuildingRepositoryIMPL extends SimpleJpaRepositoryIMPL<AssignmentBuildingEntity>
		implements AssignmentBuildingRepository {

	@Override
	public List<Long> getStaffIds(long buildingId) {
		String sql = "SELECT * FROM assignmentbuilding WHERE buildingid = " + buildingId;
		List<Long> oldStaffIds = new ArrayList<>();
		List<AssignmentBuildingEntity> result = this.findAll(sql);
		for (AssignmentBuildingEntity assignmentBuildingEntity : result) {
			oldStaffIds.add(assignmentBuildingEntity.getStaffId());
		}
		return oldStaffIds;
	}

	@Override
	public long assignmentBuilding(Long newStaffId, long buildingId) {
		AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
		assignmentBuildingEntity.setStaffId(newStaffId);
		assignmentBuildingEntity.setBuildingId(buildingId);
		long result = save(assignmentBuildingEntity);
		return result > 0 ? result : -1;
	}

	@Override
	public List<AssignmentBuildingEntity> findAllStaffAssignmentBuildingByBuildingId(long buildingId) {
		String sql = "SELECT * FROM assignmentbuilding WHERE buildingid = " + buildingId;
		List<AssignmentBuildingEntity> result = findAll(sql);
		return result != null ? result : null;
	}

	@Override
	public boolean assignBuilding(List<Long> isCheckedUsers, List<Long> unCheckedUsers, Long buildingId) {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			String sqlDelete = "DELETE FROM assignmentbuilding WHERE buildingid = ? AND staffid = ?";
			statement = connection.prepareStatement(sqlDelete);
			for (Long long1 : unCheckedUsers) {
				statement.setLong(1, buildingId);
				statement.setLong(2, long1);
				statement.execute();
			}
			String sqlInsert = "INSERT INTO assignmentbuilding(buildingid,staffid) values (?,?)";
			statement = connection.prepareStatement(sqlInsert);
			for (Long longuser : isCheckedUsers) {
				statement.setLong(1, buildingId);
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

	@Override
	public boolean updateStatus(AssignmentBuildingEntity assignmentBuildingEntity) {
		String sql = "UPDATE assignmentbuilding SET status = ? WHERE buildingid = ? AND staffid = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = true;
		try {
			connection = SingletonConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			if (assignmentBuildingEntity.getStatus().equals("")) {
				statement.setNull(1, Types.NULL);
			} else
				statement.setString(1, assignmentBuildingEntity.getStatus());
			statement.setLong(2, assignmentBuildingEntity.getBuildingId());
			statement.setLong(3, assignmentBuildingEntity.getStaffId());
			flag = statement.execute();
			return flag;
		} catch (SQLException e) {
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
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
