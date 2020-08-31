package com.laptrinhjavaweb.repository.JDBC;

import java.util.List;

import com.laptrinhjavaweb.enity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.JDBC.SimpleJpaRepository;

public interface AssignmentBuildingRepository extends SimpleJpaRepository<AssignmentBuildingEntity>{
	
	List<Long> getStaffIds(long buildingId);

	long addAssignmentBuilding(Long newStaffId, long buildingId);

	int deleteAssignmentBuilding(Long oldStaffId, long buildingId);
	
	List<AssignmentBuildingEntity> findAllStaffAssignmentBuildingByBuildingId(long buildingId);
}
