package com.laptrinhjavaweb.repository.JDBC.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.enity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.JDBC.AssignmentBuildingRepository;

public class AssignmentBuildingRepositoryIMPL extends SimpleJpaRepositoryIMPL<AssignmentBuildingEntity> implements AssignmentBuildingRepository{


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
	public int deleteAssignmentBuilding(Long oldStaffId, long buildingId) {
		String sql = "DELETE FROM assignmentbuilding WHERE staffid = " + oldStaffId + " and buildingid = " + buildingId;
		return delete(sql);
	}

	@Override
	public List<AssignmentBuildingEntity> findAllStaffAssignmentBuildingByBuildingId(long buildingId) {
		String sql = "SELECT * FROM assignmentbuilding WHERE buildingid = " + buildingId;
		List<AssignmentBuildingEntity> result = findAll(sql);
		return result != null ? result : null;
	}
	

}
