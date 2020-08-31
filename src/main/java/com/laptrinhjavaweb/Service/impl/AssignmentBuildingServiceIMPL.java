package com.laptrinhjavaweb.Service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.Convertor.AssignmentBuildingConvertor;
import com.laptrinhjavaweb.Service.AssignmentBuildingService;
import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.enity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.JDBC.AssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.JDBC.impl.AssignmentBuildingRepositoryIMPL;

public class AssignmentBuildingServiceIMPL implements AssignmentBuildingService {

	private AssignmentBuildingConvertor convertor = new AssignmentBuildingConvertor();
	private AssignmentBuildingRepository assignmentBuildingRepository = new AssignmentBuildingRepositoryIMPL();

	@Override
	public List<AssignmentBuildingDTO> addAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
		List<Long> newStaffIds = assignmentBuildingDTO.getStaffIdAssignmentBuilding();
		List<Long> oldStaffIds = assignmentBuildingRepository.getStaffIds(assignmentBuildingDTO.getBuildingId());
		List<AssignmentBuildingDTO> assignmentBuildingDTOs = new ArrayList<AssignmentBuildingDTO>();
		for (Long newStaffId : newStaffIds) {
			if (!oldStaffIds.contains(newStaffId)) {
				assignmentBuildingRepository.addAssignmentBuilding(newStaffId, assignmentBuildingDTO.getBuildingId());
			}
		}
		for (Long oldStaffId : oldStaffIds) {
			if (!newStaffIds.contains(oldStaffId)) {
				assignmentBuildingRepository.deleteAssignmentBuilding(oldStaffId, assignmentBuildingDTO.getBuildingId());
			}
		}
		
		for (AssignmentBuildingEntity assignmentBuildingEntity : assignmentBuildingRepository.findAllStaffAssignmentBuildingByBuildingId(assignmentBuildingDTO.getBuildingId())) {
			AssignmentBuildingDTO assignmentBuildingDTO1 = convertor.convertToAssignmentBuildingrDTO(assignmentBuildingEntity);
			assignmentBuildingDTOs.add(assignmentBuildingDTO1);
		}
		return assignmentBuildingDTOs;
	}

}
