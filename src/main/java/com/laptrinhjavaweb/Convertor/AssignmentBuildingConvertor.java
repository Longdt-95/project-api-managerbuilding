package com.laptrinhjavaweb.Convertor;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.enity.AssignmentBuildingEntity;

public class AssignmentBuildingConvertor {
	ModelMapper modelMapper = new ModelMapper();
	public AssignmentBuildingEntity convertToAssignmentBuildingEntity(AssignmentBuildingDTO assignmentBuildingDTO ) {
		AssignmentBuildingEntity assignmentBuildingEntity = modelMapper.map(assignmentBuildingDTO, AssignmentBuildingEntity.class);
		return assignmentBuildingEntity;
	}
	
	public AssignmentBuildingDTO convertToAssignmentBuildingrDTO(AssignmentBuildingEntity assignmentBuildingEntity) {
		AssignmentBuildingDTO assignmentBuildingDTO = modelMapper.map(assignmentBuildingEntity, AssignmentBuildingDTO.class);
		return assignmentBuildingDTO;
	}
}
