package com.laptrinhjavaweb.repository.JDBC;

import java.util.List;

import com.laptrinhjavaweb.enity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.JDBC.SimpleJpaRepository;

public interface AssignmentBuildingRepository extends SimpleJpaRepository<AssignmentBuildingEntity>{
	
	List<Long> getStaffIds(long buildingId);
	long assignmentBuilding(Long newStaffId, long buildingId);
	List<AssignmentBuildingEntity> findAllStaffAssignmentBuildingByBuildingId(long buildingId);
	boolean assignBuilding(List<Long> isCheckedUsers, List<Long> unCheckedUsers, Long BuildingId);
}
