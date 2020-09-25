package com.laptrinhjavaweb.Service;

import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;

public interface AssignmentBuildingService {
	boolean assignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);
	boolean updateStatus(AssignmentBuildingDTO assignmentBuildingDTO);
}
