package com.laptrinhjavaweb.Service;

import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.enity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.JDBC.SimpleJpaRepository;

public interface AssignmentBuildingService {
	long addAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);
}
