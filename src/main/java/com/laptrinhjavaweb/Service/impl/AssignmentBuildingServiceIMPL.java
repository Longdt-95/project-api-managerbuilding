package com.laptrinhjavaweb.Service.impl;

import com.laptrinhjavaweb.Convertor.AssignmentBuildingConvertor;
import com.laptrinhjavaweb.Service.AssignmentBuildingService;
import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.enity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.JDBC.AssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.JDBC.impl.AssignmentBuildingRepositoryIMPL;

public class AssignmentBuildingServiceIMPL implements AssignmentBuildingService{

	private AssignmentBuildingConvertor convertor = new AssignmentBuildingConvertor();
	private AssignmentBuildingRepository assignmentBuildingRepository = new AssignmentBuildingRepositoryIMPL();
	
	@Override
	public long addAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
		AssignmentBuildingEntity assignmentBuildingEntity = convertor.convertToAssignmentBuildingEntity(assignmentBuildingDTO);
		return assignmentBuildingRepository.addAssignmentBuilding(assignmentBuildingEntity);
	}


}
