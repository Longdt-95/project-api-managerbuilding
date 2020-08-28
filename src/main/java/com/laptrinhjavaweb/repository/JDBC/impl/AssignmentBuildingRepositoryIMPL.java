package com.laptrinhjavaweb.repository.JDBC.impl;

import com.laptrinhjavaweb.enity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.JDBC.AssignmentBuildingRepository;

public class AssignmentBuildingRepositoryIMPL extends SimpleJpaRepositoryIMPL<AssignmentBuildingEntity> implements AssignmentBuildingRepository{

	@Override
	public long addAssignmentBuilding(AssignmentBuildingEntity assignmentBuildingEntity) {
		return save(assignmentBuildingEntity);
	}

}
