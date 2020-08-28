package com.laptrinhjavaweb.repository.JDBC;

import com.laptrinhjavaweb.enity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.JDBC.SimpleJpaRepository;

public interface AssignmentBuildingRepository extends SimpleJpaRepository<AssignmentBuildingEntity>{
	long addAssignmentBuilding(AssignmentBuildingEntity assignmentBuildingEntity);
}
